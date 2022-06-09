package com.example.ecommcerce.user.port.out;

import com.example.ecommcerce.user.domain.model.User;

public interface UserDataProvider {

    User save(final User user);
}
