package com.rererepeatbbs.domain.dto;

import com.rererepeatbbs.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
