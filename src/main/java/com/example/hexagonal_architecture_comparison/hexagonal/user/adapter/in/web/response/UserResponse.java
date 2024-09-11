package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.response;

import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long id;
    private String name;
    private Integer age;

    private UserResponse (Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static UserResponse fromDomain(User user) {
        return new UserResponse(user.getId().getValue(), user.getName(), user.getAge());
    }
}
