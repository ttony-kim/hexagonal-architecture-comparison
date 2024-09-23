package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in;

import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;

public interface UserDeleteUseCase {
    void deleteUser(UserId userId);
}
