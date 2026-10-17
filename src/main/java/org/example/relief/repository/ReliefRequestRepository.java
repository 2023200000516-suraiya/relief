package org.example.relief.repository;

import org.example.relief.entity.ReliefRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReliefRequestRepository extends JpaRepository<ReliefRequest, Long> {

    List<ReliefRequest> findByVictimName(String victimName);
}