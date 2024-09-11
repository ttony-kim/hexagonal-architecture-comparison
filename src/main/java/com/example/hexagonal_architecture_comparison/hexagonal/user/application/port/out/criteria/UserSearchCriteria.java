package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.out.criteria;

import com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query.GetAllUsersQuery;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@Getter
public class UserSearchCriteria {
    private String name;
    private Integer age;
    private Pageable pageable;

    private UserSearchCriteria(String name, Integer age, Pageable pageable) {
        this.name = name;
        this.age = age;
        this.pageable = pageable;
    }

    public static UserSearchCriteria from(GetAllUsersQuery query) {
        return new UserSearchCriteria(query.getName(), query.getAge(), query.getPageable());
    }
}
