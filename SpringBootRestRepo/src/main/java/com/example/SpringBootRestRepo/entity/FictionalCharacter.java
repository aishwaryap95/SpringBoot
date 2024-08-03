package com.example.SpringBootRestRepo.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="fictional_character")
public class FictionalCharacter {

    @OneToOne
    private Wand wand;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=100, unique = true)
    private String name;

    @Column(length=100, nullable = false)
    private String house;

    @Column(length=100, nullable = false)
    private String bio;
    private String imgurl;

    public FictionalCharacter() {
    }

    public FictionalCharacter(int id, String house, String name) {
        this.id = id;
        this.house = house;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
