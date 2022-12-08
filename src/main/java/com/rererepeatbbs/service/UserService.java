package com.rererepeatbbs.service;

import com.rererepeatbbs.domain.dto.UserDto;
import com.rererepeatbbs.domain.dto.UserRequest;
import com.rererepeatbbs.domain.entity.User;
import com.rererepeatbbs.exception.ErrorCode;
import com.rererepeatbbs.exception.UserAppException;
import com.rererepeatbbs.repository.UserRepository;
import com.rererepeatbbs.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.secret}")
    private String secretKey;

    private long expireTimeMs = 1000 * 60 * 60;



    public UserDto join(UserRequest dto) {

        userRepository.findByUserName(dto.getUserName())
                .ifPresent(user ->{
                    throw new UserAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("userName = %s", dto.getUserName()));
                });

        User savedUser = userRepository.save(dto.toEntity(encoder.encode(dto.getPassword())));
        return UserDto.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .password(savedUser.getPassword())
                .userRole(savedUser.getUserRole())
                .build();
    }

    public String login(UserRequest dto){
        User user = userRepository.findByUserName(dto.getUserName())
                .orElseThrow(
                        () -> new UserAppException(ErrorCode.NOT_FOUNDED, String.format("%s는 회원이 아닙니다.", dto.getUserName())));
        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new UserAppException(ErrorCode.INVALID_PASSWORD, String.format("userName 또는 password가 일치하지 않습니다."));
        }
        return JwtUtil.createJwt(dto.getUserName(), secretKey, expireTimeMs);
    }
}
