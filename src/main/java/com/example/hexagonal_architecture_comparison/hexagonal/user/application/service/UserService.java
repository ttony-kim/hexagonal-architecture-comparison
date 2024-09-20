package com.example.hexagonal_architecture_comparison.hexagonal.user.application.service;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserCreateUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserReadUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserCreatePort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserReadPort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.parameters.UserLoadParameters;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserReadUseCase, UserCreateUseCase {
    private final UserReadPort userReadPort;
    private final UserCreatePort userCreatePort;

    @Override
    public Page<User> getAllUsers(GetAllUsersQuery query) {
        UserLoadParameters userLoadParameters = UserLoadParameters.from(query);
        return userReadPort.loadAllUsers(userLoadParameters);
    }

    @Override
    public User getUserById(UserId userId) {
        return userReadPort.loadUserById(userId);
    }

    @Override
    public void createUser(CreateUserCommand command) {
        User user = User.from(command.getName(), command.getAge());
        userCreatePort.saveUser(user);
    }
}
