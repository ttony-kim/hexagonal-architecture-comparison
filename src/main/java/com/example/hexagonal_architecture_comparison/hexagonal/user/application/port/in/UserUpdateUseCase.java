package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command.UpdateUserCommand;

public interface UserUpdateUseCase {
    void updateUser(UpdateUserCommand command);
}
