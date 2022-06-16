package com.example.ecommcerce.user.adapter.out.persistence.converter;

import com.example.ecommcerce.user.adapter.out.persistence.entity.UserEntity;
import com.example.ecommcerce.user.domain.model.User;

public class UserEntityConverter {

    public static UserEntity from(final User data) {
        return UserEntity.builder()
                .id(data.getId())
                .userId(data.getUserId())
                .userPw(data.getUserPw())
                .build();
    }

    public static User to(final UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .userPw(entity.getUserPw())
                .build();
    }
}
