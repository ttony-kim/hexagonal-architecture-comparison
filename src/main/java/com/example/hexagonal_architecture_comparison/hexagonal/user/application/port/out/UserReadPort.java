package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.parameters.UserLoadParameters;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import org.springframework.data.domain.Page;

public interface UserReadPort {
    Page<User> loadAllUsers(UserLoadParameters userLoadParameters);
    User loadUserById(UserId id);
}
