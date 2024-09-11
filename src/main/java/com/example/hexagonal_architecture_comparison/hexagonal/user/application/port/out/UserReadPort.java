package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out;

import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;

import java.util.List;

public interface UserReadPort {
    List<User> loadAllUsers();

    User loadUserById(UserId id);
}
