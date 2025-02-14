package com.mava.dbops.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mava.dbops.entity.Astronaut;
import com.mava.dbops.exception.ApiRequestException; // Assuming this is your custom exception class
import com.mava.dbops.repository.AstronautRepository;

@Service
public class AstronautService {

    private final AstronautRepository astronautRepository;

    @Autowired
    public AstronautService(AstronautRepository astronautRepository) {
        this.astronautRepository = astronautRepository;
    }

    public List<Astronaut> findAll() {
        return astronautRepository.findAll();
    }
    public List<Astronaut> findByFirstName(String firstName) {
        return astronautRepository.findByFirstName(firstName);
    }

    public List<Astronaut> findByLastName(String lastName) {
        return astronautRepository.findByLastName(lastName);
    }

    // If you added the method to search by both first name and last name
    public List<Astronaut> findByFullName(String firstName, String lastName) {
        return astronautRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Astronaut findById(String id) {
        return astronautRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Astronaut with ID '" + id + "' not found"));
    }

    public Astronaut save(Astronaut astronaut) {
        // You might want to set the timestamp here if it's not set in the controller or elsewhere
        if (astronaut.getTimestamp() == null) {
            astronaut.setTimestamp(new Date()); // Set the current timestamp
        }
        return astronautRepository.save(astronaut);
    }

    public void deleteById(String id) {
        if (!astronautRepository.existsById(id)) {
            throw new ApiRequestException("Cannot delete, Astronaut with ID '" + id + "' not found");
        }
        astronautRepository.deleteById(id);
    }

    

    public List<Astronaut> findByAgeGreaterThanEqual(int age) {
        List<Astronaut> astronauts = astronautRepository.findByAgeGreaterThanEqual(age);
        if (astronauts.isEmpty()) {
            throw new ApiRequestException("No astronauts found older than or equal to age " + age);
        }
        return astronauts;
    }

    public List<Astronaut> findByRank(String rank) {
        List<Astronaut> astronauts = astronautRepository.findByRankUsingQuery(rank);
        if (astronauts.isEmpty()) {
            throw new ApiRequestException("No astronauts found with rank '" + rank + "'");
        }
        return astronauts;
    }

    public long countByAtrophyStatus(String atrophyStatus) {
        return astronautRepository.countByAtrophyStatus(atrophyStatus);
    }

    // Methods related to the new fields in Astronaut entity

    public List<Astronaut> findByMissionsCompleteGreaterThanEqual(int missionsComplete) {
        List<Astronaut> astronauts = astronautRepository.findByMissionsCompleteGreaterThanEqual(missionsComplete);
        if (astronauts.isEmpty()) {
            throw new ApiRequestException("No astronauts found with missions complete greater than or equal to " + missionsComplete);
        }
        return astronauts;
    }

    public List<Astronaut> findByTimestampAfter(Date timestamp) {
        List<Astronaut> astronauts = astronautRepository.findByTimestampAfter(timestamp);
        if (astronauts.isEmpty()) {
            throw new ApiRequestException("No astronauts found added after " + timestamp);
        }
        return astronauts;
    }

    // Any other service methods you need...

}
