package com.example.SpringBootRestRepo.entity;

import jakarta.persistence.*;

@Entity
public class Wand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for primary key, auto-increment
    private int id;

    private String wood;
    private String core;
    private String length;

    public Wand() {
    }

    public Wand(int id, String length, String core, String wood) {
        this.id = id;
        this.length = length;
        this.core = core;
        this.wood = wood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

}
