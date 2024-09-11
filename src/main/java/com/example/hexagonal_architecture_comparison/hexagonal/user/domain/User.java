package com.example.hexagonal_architecture_comparison.hexagonal.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private final UserId id;
    private String name;
    private Integer age;

    @Value
    @AllArgsConstructor(staticName = "of")
    public static class UserId {
        Long value;
    }
}
