package com.example.ecommcerce.user.adapter.in.web.request.converter;

import com.example.ecommcerce.user.adapter.in.web.request.SaveUserRequest;
import com.example.ecommcerce.user.domain.command.SaveUserCommand;

public class UserRequestConverter {

    public static SaveUserCommand to(final SaveUserRequest request){
        return SaveUserCommand.builder()
                .userId(request.getUserId())
                .userPw(request.getUserPw())
                .build();
    }
}
