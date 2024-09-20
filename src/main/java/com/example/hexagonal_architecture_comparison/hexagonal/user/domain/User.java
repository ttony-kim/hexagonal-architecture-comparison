package com.example.hexagonal_architecture_comparison.hexagonal.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
public class User {
    private UserId id;
    private String name;
    private Integer age;

    private User(UserId id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this. age = age;
    }

    public static User from(UserId id, String name, Integer age) {
        return new User(id, name, age);
    }

    public static User from(String name, Integer age) {
        return new User(null, name, age);
    }

    @Value
    @AllArgsConstructor(staticName = "of")
    public static class UserId {
        Long value;
    }
}
