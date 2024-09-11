package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPersistenceMapper {

    public User mapToDomainEntity(UserEntity entity) {
        return User.builder()
                .id(User.UserId.of(entity.getId()))
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }

}
