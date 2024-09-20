package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request.UserRequest;
import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.response.UserResponse;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserReadUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserReadUseCase userReadUseCase;
    private final UserResponseMapper mapper;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUsers(UserRequest userRequest, Pageable pageable) {
        GetAllUsersQuery query = GetAllUsersQuery.from(userRequest, pageable);
        Page<User> allUsers = userReadUseCase.getAllUsers(query);
        return mapper.mapToUserResponse(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        User user = userReadUseCase.getUserById(UserId.of(id));
        return mapper.mapToUserResponse(user);
    }
}

