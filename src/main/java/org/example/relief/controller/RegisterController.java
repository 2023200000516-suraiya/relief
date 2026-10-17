package org.example.relief.controller;

import org.example.relief.entity.User;
import org.example.relief.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        user.setRole("VICTIM");

        userService.registerUser(user);

        return "redirect:/login";
    }
}