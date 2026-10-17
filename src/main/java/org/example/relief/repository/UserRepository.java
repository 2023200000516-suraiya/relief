package org.example.relief.repository;

import org.example.relief.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPasswordAndRole(
            String email,
            String password,
            String role
    );
}