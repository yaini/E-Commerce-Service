package com.example.ecommcerce.user.domain.service;

import com.example.ecommcerce.user.domain.model.User;
import com.example.ecommcerce.user.domain.query.GetUserQuery;
import com.example.ecommcerce.user.port.in.GetUserUseCase;
import com.example.ecommcerce.user.port.out.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GetUserService implements GetUserUseCase {

    private final UserDataProvider dataProvider;

    @Override
    public User execute(final @Valid GetUserQuery query) {
        return dataProvider.findOne(query.getId())
                .orElseThrow();
    }
}
