package org.example.relief.repository;

import org.example.relief.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    List<Shelter> findByLocationIgnoreCase(String location);
}