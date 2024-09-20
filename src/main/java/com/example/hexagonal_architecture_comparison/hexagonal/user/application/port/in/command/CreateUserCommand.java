package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request.UserCreateRequest;
import lombok.Getter;

@Getter
public class CreateUserCommand {
    private String name;
    private Integer age;

    private CreateUserCommand(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static CreateUserCommand from(UserCreateRequest request) {
        return new CreateUserCommand(request.getName(), request.getAge());
    }
}
