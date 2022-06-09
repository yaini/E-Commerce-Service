package com.example.ecommcerce.user.adapter.in.web.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String userId;
}
