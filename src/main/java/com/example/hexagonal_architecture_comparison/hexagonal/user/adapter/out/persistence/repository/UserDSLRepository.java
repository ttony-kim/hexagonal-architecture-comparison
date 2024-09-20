package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.repository;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.parameters.UserLoadParameters;
import org.springframework.data.domain.Page;

public interface UserDSLRepository {
    Page<UserEntity> findBySearchCriteria(UserLoadParameters userLoadParameters);
}
