package com.mlb.mlb_api.repositories.entities;

import com.mlb.mlb_api.controllers.dto.PlayerDTO;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private  Integer id;
    private String name;
    private Integer age;
    private Double cost;
    private String position;
    @Column(name = "current_team")
    private String currentTeam;


    public Player() {
    }

    public Player(PlayerDTO playerDTO) {
        this.name = playerDTO.getName();
        this.age = playerDTO.getAge();
        this.cost = playerDTO.getCost();
        this.position = playerDTO.getPosition();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", yearsOfExperience=" + cost +
                ", rating=" + position +
                '}';
    }
}
