package com.example.ecommcerce.user.adapter.out.persistence;

import com.example.ecommcerce.user.adapter.out.persistence.converter.UserEntityConverter;
import com.example.ecommcerce.user.adapter.out.persistence.entity.UserEntity;
import com.example.ecommcerce.user.adapter.out.persistence.repository.UserRepository;
import com.example.ecommcerce.user.domain.model.User;
import com.example.ecommcerce.user.port.out.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserDataPersistenceAdapter implements UserDataProvider {

    private final UserRepository repository;

    @Override
    public Optional<User> findOne(Long id) {
        return repository.findById(id).map(UserEntityConverter::to);
    }

    @Override
    public User save(final User user) {
        UserEntity entity = UserEntityConverter.from(user);
        return UserEntityConverter.to(repository.save(entity));
    }
}
