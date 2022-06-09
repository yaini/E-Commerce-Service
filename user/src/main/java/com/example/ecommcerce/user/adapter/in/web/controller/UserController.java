package com.example.ecommcerce.user.adapter.in.web.controller;

import com.example.ecommcerce.user.adapter.in.web.UserWebAdapter;
import com.example.ecommcerce.user.adapter.in.web.request.SaveUserRequest;
import com.example.ecommcerce.user.adapter.in.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private final UserWebAdapter adapter;

    @PostMapping
    public UserResponse register(final SaveUserRequest request){
        return adapter.add(request);
    }
}
