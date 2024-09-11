package com.example.hexagonal_architecture_comparison.hexagonal.user.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;
    private Integer age;
    private String status;

}
