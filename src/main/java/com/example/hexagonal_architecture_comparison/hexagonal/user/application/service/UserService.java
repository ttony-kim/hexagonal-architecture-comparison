package com.example.hexagonal_architecture_comparison.hexagonal.user.application.service;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserReadUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetUserQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserReadPort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserReadUseCase {
    private final UserReadPort userReadPort;

    @Override
    public List<User> getAllUsers() {
        return userReadPort.loadAllUsers();
    }

    @Override
    public User getUserById(GetUserQuery userQuery) {
        return userReadPort.loadUserById(userQuery.getUserId());
    }
}
