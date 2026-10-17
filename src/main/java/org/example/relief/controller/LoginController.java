package org.example.relief.controller;

import org.example.relief.entity.User;
import org.example.relief.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role,
            Model model) {

        User user = userService.loginUser(email, password, role);

        if (user == null) {
            model.addAttribute(
                    "error",
                    "Invalid email, password or role"
            );

            return "login";
        }

        if (role.equalsIgnoreCase("ADMIN")) {
            return "redirect:/admin";
        }

        if (role.equalsIgnoreCase("VOLUNTEER")) {
            return "redirect:/volunteer";
        }

        if (role.equalsIgnoreCase("VICTIM")) {
            return "redirect:/victim";
        }

        return "redirect:/";
    }
}