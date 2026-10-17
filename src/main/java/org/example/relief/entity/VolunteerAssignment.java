package org.example.relief.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteer_assignments")
public class VolunteerAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String volunteerName;
    private Long reliefRequestId;
    private String assignedDate;
    private String status;

    public VolunteerAssignment() {
    }

    public Long getId() {
        return id;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public Long getReliefRequestId() {
        return reliefRequestId;
    }

    public void setReliefRequestId(Long reliefRequestId) {
        this.reliefRequestId = reliefRequestId;
    }

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}