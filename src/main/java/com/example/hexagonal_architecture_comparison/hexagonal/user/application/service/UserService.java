package com.example.hexagonal_architecture_comparison.hexagonal.user.application.service;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserCreateUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserDeleteUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserReadUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserUpdateUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command.UpdateUserCommand;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserDeletePort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserReadPort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserCreatePort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserUpdatePort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.parameters.UserLoadParameters;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserService implements UserReadUseCase, UserCreateUseCase, UserUpdateUseCase, UserDeleteUseCase {
    private final UserReadPort userReadPort;
    private final UserCreatePort userCreatePort;
    private final UserUpdatePort userUpdatePort;
    private final UserDeletePort userDeletePort;

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

    @Override
    public void updateUser(UpdateUserCommand command) {
        User user = User.from(UserId.of(command.getId()), command.getName(), command.getAge());
        userUpdatePort.updateUser(user);
    }

    @Override
    public void deleteUser(UserId userId) {
        userDeletePort.deleteUser(userId);
    }
}
