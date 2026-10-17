package org.example.relief.controller;

import org.example.relief.entity.Shelter;
import org.example.relief.repository.ShelterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShelterController {

    private final ShelterRepository repository;

    public ShelterController(ShelterRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/shelter")
    public String shelterPage(Model model) {

        model.addAttribute(
                "shelters",
                repository.findAll()
        );

        return "shelter";
    }

    @GetMapping("/shelter/search")
    public String searchShelter(
            @RequestParam String location,
            Model model) {

        model.addAttribute(
                "shelters",
                repository.findByLocationIgnoreCase(location)
        );

        return "shelter";
    }

    @PostMapping("/shelter/add")
    public String addShelter(
            @ModelAttribute Shelter shelter) {

        repository.save(shelter);

        return "redirect:/shelter";
    }
}