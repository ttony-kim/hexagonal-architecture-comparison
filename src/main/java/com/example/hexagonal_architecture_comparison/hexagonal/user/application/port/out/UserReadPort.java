package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.criteria.UserSearchCriteria;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import org.springframework.data.domain.Page;

public interface UserReadPort {
    Page<User> loadAllUsers(UserSearchCriteria userSearchCriteria);
    User loadUserById(UserId id);
}
