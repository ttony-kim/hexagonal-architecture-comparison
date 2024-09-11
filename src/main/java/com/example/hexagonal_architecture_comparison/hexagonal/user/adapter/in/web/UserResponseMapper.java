package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.response.UserResponse;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserResponseMapper {
    ResponseEntity<List<UserResponse>> mapToUserResponse(List<User> users) {
        List<UserResponse> response = users.stream()
                .map(UserResponse::fromDomain)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    ResponseEntity<UserResponse> mapToUserResponse(User user) {
        UserResponse response = UserResponse.fromDomain(user);

        return ResponseEntity.ok(response);
    }
}
