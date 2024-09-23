package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.response.UserResponse;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class UserResponseMapper {
    ResponseEntity<Page<UserResponse>> mapToUserResponse(Page<User> users) {
        Page<UserResponse> response = users.map(UserResponse::fromDomain);

        return ResponseEntity.ok(response);
    }

    ResponseEntity<UserResponse> mapToUserResponse(User user) {
        UserResponse response = UserResponse.fromDomain(user);

        return ResponseEntity.ok(response);
    }
}
