package org.example.relief.controller;

import org.example.relief.entity.ReliefRequest;
import org.example.relief.entity.Shelter;
import org.example.relief.repository.ReliefRequestRepository;
import org.example.relief.repository.ShelterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VictimController {

    private final ReliefRequestRepository reliefRepository;
    private final ShelterRepository shelterRepository;

    public VictimController(
            ReliefRequestRepository reliefRepository,
            ShelterRepository shelterRepository) {

        this.reliefRepository = reliefRepository;
        this.shelterRepository = shelterRepository;
    }

    @GetMapping("/victim")
    public String victimPage(Model model) {

        model.addAttribute(
                "requests",
                reliefRepository.findAll()
        );

        model.addAttribute(
                "shelters",
                shelterRepository.findAll()
        );

        return "victim";
    }

    @PostMapping("/victim/request")
    public String submitReliefRequest(
            @ModelAttribute ReliefRequest request) {

        request.setStatus("PENDING");

        reliefRepository.save(request);

        return "redirect:/victim";
    }

    @GetMapping("/victim/shelter")
    public String findShelter(
            @RequestParam String location,
            Model model) {

        List<Shelter> shelters =
                shelterRepository.findByLocationIgnoreCase(location);

        model.addAttribute("shelters", shelters);

        model.addAttribute(
                "requests",
                reliefRepository.findAll()
        );

        return "victim";
    }
}