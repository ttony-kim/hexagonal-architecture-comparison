package com.example.hexagonal_architecture_comparison.hexagonal.user.application.service;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserReadUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.UserReadPort;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.criteria.UserSearchCriteria;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserReadUseCase {
    private final UserReadPort userReadPort;

    @Override
    public Page<User> getAllUsers(GetAllUsersQuery query) {
        UserSearchCriteria userSearchCriteria = UserSearchCriteria.from(query);
        return userReadPort.loadAllUsers(userSearchCriteria);
    }

    @Override
    public User getUserById(UserId userId) {
        return userReadPort.loadUserById(userId);
    }
}
