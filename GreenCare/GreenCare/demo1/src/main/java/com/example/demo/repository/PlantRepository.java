package com.example.demo.repository;

import com.example.demo.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    Optional<Plant> findById(Long id);
    List<Plant> findByNameContainingIgnoreCase(String name);
}