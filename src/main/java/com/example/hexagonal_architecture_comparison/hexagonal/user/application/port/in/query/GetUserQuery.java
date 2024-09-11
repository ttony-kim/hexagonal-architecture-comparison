package com.example.hexagonal_architecture_comparison.hexagonal.user.application.port.in.query;

import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.User.UserId;
import lombok.Getter;

@Getter
public class GetUserQuery {
    private UserId userId;

    private GetUserQuery(UserId userId) {
        this.userId = userId;
    }

    public static GetUserQuery of(Long id) {
        return new GetUserQuery(UserId.of(id));
    }
}
