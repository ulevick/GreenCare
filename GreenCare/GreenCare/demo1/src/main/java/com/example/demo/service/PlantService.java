package com.example.demo.service;

import com.example.demo.dto.PlantDto;
import com.example.demo.model.Plant;
import com.example.demo.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public List<PlantDto> getAllPlants() {
        return plantRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public PlantDto getPlantById(Long id) {
        return plantRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    private PlantDto convertToDTO(Plant plant) {
        PlantDto dto = new PlantDto();
        dto.setId(plant.getId());
        dto.setName(plant.getName());
        dto.setDescription(plant.getDescription());
        dto.setPrice(plant.getPrice());
        dto.setInStock(plant.getInStock());
        dto.setCare(plant.getCare());
        dto.setInclude(plant.getInclude());
        dto.setAvailablePotColors(Arrays.asList("#e6e8ea", "#c78356", "#3b4037", "#b7c7cd", "#3b5d7d"));
        dto.setImageUrls(plant.getImageUrls());
        return dto;
    }
    public List<PlantDto> getPlantsByName(String name) {
        return plantRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
