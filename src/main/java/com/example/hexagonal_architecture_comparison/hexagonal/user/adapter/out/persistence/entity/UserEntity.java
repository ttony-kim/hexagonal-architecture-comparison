package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity;

import com.example.hexagonal_architecture_comparison.hexagonal.user.domain.UserStatus;
import jakarta.persistence.*;
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
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    private UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static UserEntity from(String name, Integer age) {
        return new UserEntity(name, age);
    }

    public void insert() {
        this.status = UserStatus.INSERT;
    }

    public void update(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.status = UserStatus.UPDATE;
    }
}
