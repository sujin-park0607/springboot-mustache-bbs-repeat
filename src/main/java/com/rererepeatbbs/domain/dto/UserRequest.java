package com.rererepeatbbs.domain.dto;

import com.rererepeatbbs.domain.entity.User;
import com.rererepeatbbs.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequest {
    private String userName;
    private String password;

    public User toEntity(String password) {
        return User.builder()
                .userName(this.userName)
                .password(password)
                .userRole(UserRole.USER)
                .build();
    }
}
