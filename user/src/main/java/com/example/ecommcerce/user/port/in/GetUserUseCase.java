package com.example.ecommcerce.user.port.in;

import com.example.ecommcerce.user.domain.model.User;
import com.example.ecommcerce.user.domain.query.GetUserQuery;

import javax.validation.Valid;

public interface GetUserUseCase {

    User execute(final @Valid GetUserQuery query);
}
