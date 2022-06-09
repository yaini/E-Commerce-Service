package com.example.ecommcerce.user.adapter.in.web;

import com.example.ecommcerce.user.adapter.in.web.request.SaveUserRequest;
import com.example.ecommcerce.user.adapter.in.web.request.converter.UserRequestConverter;
import com.example.ecommcerce.user.adapter.in.web.response.UserResponse;
import com.example.ecommcerce.user.adapter.in.web.response.converter.UserResponseConverter;
import com.example.ecommcerce.user.domain.model.User;
import com.example.ecommcerce.user.port.in.SaveUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Component
public class UserWebAdapter {

    private final SaveUserUseCase saveUseCase;

    public UserResponse add(final SaveUserRequest request){
        User user = saveUseCase.execute(UserRequestConverter.to(request));
        return UserResponseConverter.from(user);
    }
}
