package com.example.ecommcerce.user.domain.command;

import com.example.ecommcerce.user.domain.model.User;
import lombok.Builder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
                .userPw(new BCryptPasswordEncoder().encode(this.userPw))
                .build();
    }
}
