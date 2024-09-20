package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request;

import lombok.Getter;

@Getter
public class UserUpdateRequest {
    private String name;
    private Integer age;
}
