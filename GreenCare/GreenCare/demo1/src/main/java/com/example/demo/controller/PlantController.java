package com.example.demo.controller;

import com.example.demo.dto.PlantDto;
import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<PlantDto> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping(params = "name")
    public List<PlantDto> getPlantsByName(@RequestParam String name) {
        return plantService.getPlantsByName(name);
    }

    @GetMapping("/{plantId}")
    public PlantDto getPlantById(@PathVariable Long plantId) {
        return plantService.getPlantById(plantId);
    }
}

