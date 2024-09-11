package com.example.hexagonal_architecture_comparison.hs.user.dto;

import com.example.hexagonal_architecture_comparison.hs.user.entity.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Integer age;

    public static UserSaveDto toDto(User user) {
        return UserSaveDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}
