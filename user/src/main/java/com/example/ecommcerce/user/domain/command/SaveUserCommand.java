package com.example.ecommcerce.user.domain.command;

import com.example.ecommcerce.user.domain.model.User;
import lombok.Builder;

import javax.validation.constraints.NotBlank;

@Builder
public class SaveUserCommand {

    @NotBlank
    private String userId;

    @NotBlank
    private String userPw;

    public User getUser(){
        return User.builder()
                .userId(this.userId)
                .userPw(this.userPw)
                .build();
    }
}
