package com.example.ecommcerce.user.port.out;

import com.example.ecommcerce.user.domain.model.User;

import java.util.Optional;

public interface UserDataProvider {

    Optional<User> findOne(final Long id);

    User save(final User user);
}
