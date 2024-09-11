package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.in.web.request.UserRequest;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@Getter
public class GetAllUsersQuery {
    private String name;
    private Integer age;
    private Pageable pageable;

    private GetAllUsersQuery(String name, Integer age, Pageable pageable) {
        this.name = name;
        this.age = age;
        this.pageable = pageable;
    }

    public static GetAllUsersQuery from(UserRequest request, Pageable pageable) {
        return new GetAllUsersQuery(request.getName(), request.getAge(), pageable);
    }
}
