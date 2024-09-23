package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request.UserCreateRequest;
import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request.UserSearchRequest;
import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request.UserUpdateRequest;
import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.response.UserResponse;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserCreateUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserDeleteUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserReadUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.UserUpdateUseCase;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command.CreateUserCommand;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command.UpdateUserCommand;
import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserReadUseCase userReadUseCase;
    private final UserCreateUseCase userCreateUseCase;
    private final UserUpdateUseCase userUpdateUseCase;
    private final UserDeleteUseCase userDeleteUseCase;
    private final UserResponseMapper mapper;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUsers(UserSearchRequest request, Pageable pageable) {
        GetAllUsersQuery query = GetAllUsersQuery.from(request, pageable);
        Page<User> allUsers = userReadUseCase.getAllUsers(query);
        return mapper.mapToUserResponse(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        User user = userReadUseCase.getUserById(UserId.of(id));
        return mapper.mapToUserResponse(user);
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest request) {
        CreateUserCommand command = CreateUserCommand.from(request);
        userCreateUseCase.createUser(command);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        UpdateUserCommand command = UpdateUserCommand.from(id, request);
        userUpdateUseCase.updateUser(command);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDeleteUseCase.deleteUser(UserId.of(id));
    }
}

