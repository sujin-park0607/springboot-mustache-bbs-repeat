package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.Response;
import com.rererepeatbbs.domain.dto.UserDto;
import com.rererepeatbbs.domain.dto.UserRequest;
import com.rererepeatbbs.domain.dto.UserResponse;
import com.rererepeatbbs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserResponse> join(@RequestBody UserRequest dto) {
        UserDto user = userService.join(dto);
        return Response.success(new UserResponse(user.getId(), user.getUserName()));
    }

    @PostMapping("/login")
    public Response<String> login(@RequestBody UserRequest dto) {
        String token = userService.login(dto);
        return Response.success(token);
    }
}