package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.command;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request.UserUpdateRequest;
import lombok.Getter;

@Getter
public class UpdateUserCommand {
    private Long id;
    private String name;
    private Integer age;

    private UpdateUserCommand(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static UpdateUserCommand from( Long id, UserUpdateRequest request) {
        return new UpdateUserCommand(id, request.getName(), request.getAge());
    }
}
