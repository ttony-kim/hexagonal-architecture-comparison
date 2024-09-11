package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.response.UserResponse;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserReadUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetUserQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserReadUseCase userReadUseCase;
    private final UserResponseMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> allUsers = userReadUseCase.getAllUsers();
        return mapper.mapToUserResponse(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        GetUserQuery query = GetUserQuery.from(id);
        User user = userReadUseCase.getUserById(query);
        return mapper.mapToUserResponse(user);
    }
}

