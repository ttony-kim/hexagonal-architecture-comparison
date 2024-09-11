package com.example.hexagonal_architecture_comparison.hs.user.repository;

import com.example.hexagonal_architecture_comparison.hs.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserDSLRepository {
}
