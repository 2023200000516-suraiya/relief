package org.example.relief.repository;

import org.example.relief.entity.VolunteerAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerAssignmentRepository
        extends JpaRepository<VolunteerAssignment, Long> {

    List<VolunteerAssignment> findByVolunteerName(String volunteerName);
}