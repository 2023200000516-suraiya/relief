package org.example.relief.controller;

import org.example.relief.entity.ReliefRequest;
import org.example.relief.repository.ReliefRequestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReliefRequestController {

    private final ReliefRequestRepository repository;

    public ReliefRequestController(ReliefRequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/relief")
    public String reliefPage(Model model) {

        model.addAttribute("requests", repository.findAll());

        return "relief";
    }

    @PostMapping("/relief/request")
    public String createRequest(
            @ModelAttribute ReliefRequest request) {

        request.setStatus("PENDING");

        repository.save(request);

        return "redirect:/relief";
    }

    @PostMapping("/relief/update")
    public String updateStatus(
            @RequestParam("id") Long id,
            @RequestParam("status") String status) {

        ReliefRequest request = repository.findById(id).orElse(null);

        if (request != null) {
            request.setStatus(status);
            repository.save(request);
        }

        return "redirect:/relief";
    }
}