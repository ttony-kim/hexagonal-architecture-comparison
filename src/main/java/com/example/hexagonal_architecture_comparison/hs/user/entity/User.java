package com.example.hexagonal_architecture_comparison.hs.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;
    private Integer age;
    private String status;

    public void insert() {
        this.status = "INSERT";
    }

    public void update(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.status = "UPDATE";
    }

    public void delete() {
        this.status = "DELETE";
    }
}
