package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity;

import com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.enums.Status;
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
    private Status status;

    private UserEntity(String name, Integer age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public static UserEntity from(String name, Integer age, Status status) {
        return new UserEntity(name, age, status);
    }
}
