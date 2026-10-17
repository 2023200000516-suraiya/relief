package org.example.relief.service;

import org.example.relief.entity.User;
import org.example.relief.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email, String password, String role) {

        return userRepository
                .findByEmailAndPasswordAndRole(email, password, role)
                .orElse(null);
    }
    public boolean resetPassword(
            String email,
            String newPassword,
            String confirmPassword) {

        if (!newPassword.equals(confirmPassword)) {
            return false;
        }

        User user = userRepository
                .findByEmail(email)
                .orElse(null);

        if (user == null) {
            return false;
        }

        user.setPassword(newPassword);

        userRepository.save(user);

        return true;
    }
}