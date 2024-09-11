package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetUserQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import org.springframework.data.domain.Page;

public interface UserReadUseCase {
    Page<User> getAllUsers(GetAllUsersQuery query);
    User getUserById(GetUserQuery query);
}
