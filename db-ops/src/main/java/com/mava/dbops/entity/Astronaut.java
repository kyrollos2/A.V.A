package com.mava.dbops.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "astronauts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Astronaut {
    
    @Id
    private String id;
    
    private String rank;
    
    @Field("last_name") // Adjusted to match MongoDB field name
    private String lastName;
    
    @Field("first_name") // Adjusted to match MongoDB field name
    private String firstName;
    
    private int age;
    private double height;
    private double weight;
    private String sex;
    
    @Field("atrophy_status") // Adjusted to match MongoDB field name
    private String atrophyStatus;
    
    private Date timestamp; // Assuming you want to store the timestamp as a Date object
    
    @Field("missions_complete") // Adjusted to match MongoDB field name
    private int missionsComplete; // Assuming you want to store the missions complete as an integer

    // Constructors, Getters, and Setters are omitted for brevity
}