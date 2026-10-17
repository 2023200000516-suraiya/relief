package org.example.relief.controller;

import org.example.relief.entity.ReliefRequest;
import org.example.relief.entity.Shelter;
import org.example.relief.entity.VolunteerAssignment;
import org.example.relief.repository.ReliefRequestRepository;
import org.example.relief.repository.ShelterRepository;
import org.example.relief.repository.VolunteerAssignmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private final ReliefRequestRepository reliefRepository;
    private final ShelterRepository shelterRepository;
    private final VolunteerAssignmentRepository assignmentRepository;

    public AdminController(
            ReliefRequestRepository reliefRepository,
            ShelterRepository shelterRepository,
            VolunteerAssignmentRepository assignmentRepository) {

        this.reliefRepository = reliefRepository;
        this.shelterRepository = shelterRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {

        model.addAttribute(
                "requests",
                reliefRepository.findAll()
        );

        model.addAttribute(
                "shelters",
                shelterRepository.findAll()
        );

        model.addAttribute(
                "assignments",
                assignmentRepository.findAll()
        );

        return "admin";
    }

    @PostMapping("/admin/status")
    public String updateStatus(
            @RequestParam Long id,
            @RequestParam String status) {

        ReliefRequest request =
                reliefRepository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus(status);
            reliefRepository.save(request);
        }

        return "redirect:/admin";
    }

    @PostMapping("/admin/assign")
    public String assignVolunteer(
            @ModelAttribute VolunteerAssignment assignment) {

        assignment.setStatus("ASSIGNED");

        assignmentRepository.save(assignment);

        return "redirect:/admin";
    }

    @PostMapping("/admin/shelter")
    public String addShelter(
            @ModelAttribute Shelter shelter) {

        shelterRepository.save(shelter);

        return "redirect:/admin";
    }
}