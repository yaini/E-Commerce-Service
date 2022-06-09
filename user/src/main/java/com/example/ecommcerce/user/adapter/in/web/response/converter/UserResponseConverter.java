package com.example.ecommcerce.user.adapter.in.web.response.converter;

import com.example.ecommcerce.user.adapter.in.web.response.UserResponse;
import com.example.ecommcerce.user.domain.model.User;

public class UserResponseConverter {

    public static UserResponse from(final User user){
        return UserResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .build();
    }
}
