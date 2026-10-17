package org.example.relief.controller;

import org.example.relief.entity.VolunteerAssignment;
import org.example.relief.repository.VolunteerAssignmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VolunteerAssignmentController {

    private final VolunteerAssignmentRepository repository;

    public VolunteerAssignmentController(VolunteerAssignmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/volunteer")
    public String volunteerPage(Model model) {

        model.addAttribute("assignments",
                repository.findAll()
        );

        return "volunteer";
    }

    @PostMapping("/volunteer/assign")
    public String assignVolunteer(
            @ModelAttribute VolunteerAssignment assignment) {

        assignment.setStatus("ASSIGNED");

        repository.save(assignment);

        return "redirect:/volunteer";
    }
}