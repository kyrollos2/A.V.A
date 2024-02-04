package com.mava.mavadb.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "astronauts")
@Data
public class Astronaut {
    
    @Id
    private String id;
    private String rank;
    private String lastName;
    private String firstName;
    private int age;
    private double height;
    private double weight;
    private String sex;
    private String atrophyStatus;
    private Date timestamp; // Assuming you want to store the timestamp as a Date object
    private int missionsComplete; // Assuming you want to store the missions complete as an integer

    public Astronaut() {}

    // Updated constructor with new fields
    public Astronaut (String id, String rank, String lastName, String firstName, int age, double height, double weight, String sex, String atrophyStatus, Date timestamp, int missionsComplete)  {
        
        this.id = id;
        this.rank = rank;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.atrophyStatus = atrophyStatus;
        
    }

}
