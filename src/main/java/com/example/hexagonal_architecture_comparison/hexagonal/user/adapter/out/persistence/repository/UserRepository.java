package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.repository;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserDSLRepository {
}
