package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetUserQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;

import java.util.List;

public interface UserReadUseCase {
    List<User> getAllUsers();

    User getUserById(GetUserQuery userQuery);
}
