package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.repository.UserRepository;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserReadPort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class UserPersistenceAdapter implements UserReadPort {
    private final UserRepository userRepository;
    private final UserPersistenceMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<User> loadAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::mapToDomainEntity)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public User loadUserById(UserId id) {
        return userRepository.findById(id.getValue())
                .map(mapper::mapToDomainEntity)
                .orElseThrow();
    }
}
