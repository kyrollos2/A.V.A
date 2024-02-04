package com.mava.dbops.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mava.dbops.entity.Astronaut;

@Repository
public interface AstronautRepository extends MongoRepository<Astronaut, String> {

    List<Astronaut> findByFirstName(String firstName);
    List<Astronaut> findByLastName(String lastName);
    List<Astronaut> findByFirstNameAndLastName(String firstName, String lastName);

    List<Astronaut> findByAgeGreaterThanEqual(int age);

    @Query("{ 'rank' : ?0 }")
    List<Astronaut> findByRankUsingQuery(String rank);

    @Query(value="{ 'atrophyStatus' : ?0 }", count=true)
    long countByAtrophyStatus(String atrophyStatus);

    // Example methods for new fields
    List<Astronaut> findByMissionsCompleteGreaterThanEqual(int missionsComplete);

    // Querying astronauts added after a certain timestamp
    List<Astronaut> findByTimestampAfter(Date timestamp);
}
