package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.enums.UserStatus;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {
    public User mapToDomain(UserEntity entity) {
        return User.from(User.UserId.of(entity.getId()), entity.getName(), entity.getAge());
    }

    public UserEntity mapToEntity(User user, UserStatus userStatus) {
        return UserEntity.from(user.getName(), user.getAge(), userStatus);
    }
}
