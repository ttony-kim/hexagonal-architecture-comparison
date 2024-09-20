package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {
    private String name;
    private Integer age;
}
