package com.mava.mavadb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mava.mavadb.entity.Astronaut;
import com.mava.mavadb.service.AstronautService;

@RestController
@RequestMapping("/api/astronauts")
public class AstronautController {

    private final AstronautService astronautService;

    @Autowired
    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }

    @GetMapping
    public List<Astronaut> getAllAstronauts() {
        return astronautService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Astronaut> getAstronautById(@PathVariable String id) {
        Astronaut astronaut = astronautService.findById(id);
        return ResponseEntity.ok(astronaut);
    }

    @PostMapping
    public Astronaut createAstronaut(@RequestBody Astronaut astronaut) {
        return astronautService.save(astronaut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Astronaut> updateAstronaut(@PathVariable String id, @RequestBody Astronaut astronautDetails) {
        Astronaut astronaut = astronautService.findById(id); // findById now returns an Astronaut directly, handling exceptions internally
        astronaut.setRank(astronautDetails.getRank());
        astronaut.setLastName(astronautDetails.getLastName());
        astronaut.setFirstName(astronautDetails.getFirstName());
        astronaut.setAge(astronautDetails.getAge());
        astronaut.setHeight(astronautDetails.getHeight());
        astronaut.setWeight(astronautDetails.getWeight());
        astronaut.setSex(astronautDetails.getSex());
        astronaut.setAtrophyStatus(astronautDetails.getAtrophyStatus());
        // Assume that timestamp and missionsComplete are managed internally and not updated through PUT
        Astronaut updatedAstronaut = astronautService.save(astronaut);
        return ResponseEntity.ok(updatedAstronaut);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstronaut(@PathVariable String id) {
        astronautService.deleteById(id); // deleteById now handles exceptions internally
        return ResponseEntity.noContent().build(); // Changed to noContent for successful delete without body
    }

    // Additional endpoints can be added here for new fields if necessary

    // Error handling can be done using @ExceptionHandler if you want to catch ApiRequestException globally
}
