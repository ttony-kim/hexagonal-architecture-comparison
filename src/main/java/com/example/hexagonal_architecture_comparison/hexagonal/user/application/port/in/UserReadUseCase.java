package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import org.springframework.data.domain.Page;

public interface UserReadUseCase {
    Page<User> getAllUsers(GetAllUsersQuery query);
    User getUserById(UserId userId);
}
