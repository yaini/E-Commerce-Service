package com.example.ecommcerce.user.domain.service;

import com.example.ecommcerce.user.domain.command.SaveUserCommand;
import com.example.ecommcerce.user.domain.model.User;
import com.example.ecommcerce.user.port.in.SaveUserUseCase;
import com.example.ecommcerce.user.port.out.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Transactional
@RequiredArgsConstructor
@Service
public class SaveUserService implements SaveUserUseCase {

    private final UserDataProvider dataProvider;

    @Override
    public User execute(final @Valid SaveUserCommand command) {
        return dataProvider.save(command.getUser());
    }
}
