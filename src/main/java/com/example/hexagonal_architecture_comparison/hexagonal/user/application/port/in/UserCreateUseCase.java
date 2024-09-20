package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command.CreateUserCommand;

public interface UserCreateUseCase {
    void createUser(CreateUserCommand command);
}
