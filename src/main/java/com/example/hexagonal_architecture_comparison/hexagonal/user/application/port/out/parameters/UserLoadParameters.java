package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.parameters;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@Getter
public class UserLoadParameters {
    private String name;
    private Integer age;
    private Pageable pageable;

    private UserLoadParameters(String name, Integer age, Pageable pageable) {
        this.name = name;
        this.age = age;
        this.pageable = pageable;
    }

    public static UserLoadParameters from(GetAllUsersQuery query) {
        return new UserLoadParameters(query.getName(), query.getAge(), query.getPageable());
    }
}
