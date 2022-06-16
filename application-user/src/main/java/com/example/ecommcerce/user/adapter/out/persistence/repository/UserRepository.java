package com.example.ecommcerce.user.adapter.out.persistence.repository;

import com.example.ecommcerce.user.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
