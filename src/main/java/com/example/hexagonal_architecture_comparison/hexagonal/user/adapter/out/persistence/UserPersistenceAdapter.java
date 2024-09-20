package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.enums.UserStatus;
import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.repository.UserRepository;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserCreatePort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserReadPort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.parameters.UserLoadParameters;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class UserPersistenceAdapter implements UserReadPort, UserCreatePort {
    private final UserRepository userRepository;
    private final UserPersistenceMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Page<User> loadAllUsers(UserLoadParameters userLoadParameters) {
        Page<UserEntity> userEntities = userRepository.findBySearchCriteria(userLoadParameters);
        return userEntities.map(mapper::mapToDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public User loadUserById(UserId id) {
        return userRepository.findById(id.getValue())
                .map(mapper::mapToDomain)
                .orElseThrow();
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = mapper.mapToEntity(user, UserStatus.INSERT);
        userRepository.save(userEntity);
    }
}
