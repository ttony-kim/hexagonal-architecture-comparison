package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "tbl_user1")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;
    private Integer age;
    private UserStatus userStatus;

    private UserEntity(String name, Integer age, UserStatus userStatus) {
        this.name = name;
        this.age = age;
        this.userStatus = userStatus;
    }

    public static UserEntity from(String name, Integer age, UserStatus userStatus) {
        return new UserEntity(name, age, userStatus);
    }
}
