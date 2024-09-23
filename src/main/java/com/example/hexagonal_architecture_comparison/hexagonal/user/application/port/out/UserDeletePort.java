package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out;

import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;

public interface UserDeletePort {
    void deleteUser(UserId id);
}
