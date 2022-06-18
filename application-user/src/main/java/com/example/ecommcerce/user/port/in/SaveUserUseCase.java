package com.example.ecommcerce.user.port.in;

import com.example.ecommcerce.user.domain.command.SaveUserCommand;
import com.example.ecommcerce.user.domain.model.User;

import javax.validation.Valid;

public interface SaveUserUseCase {

    User execute(final @Valid SaveUserCommand command);
}
