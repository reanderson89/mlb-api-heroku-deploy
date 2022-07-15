package com.mlb.mlb_api.repositories.entities;


import com.mlb.mlb_api.controllers.dto.TeamDTO;

import javax.persistence.*;
import java.util.ArrayList;



@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private  Integer id;
    private String name;
    private String location;
    private Double budget = 150.0;
    private ArrayList<Integer> teamroster = new ArrayList<>();
    private ArrayList<Integer> infielders = new ArrayList<>();
    private ArrayList<Integer> outfielders = new ArrayList<>();
    private ArrayList<Integer> pitchers = new ArrayList<>();

    public Team() {
    }

    public Team(TeamDTO teamDTO) {
        this.name = teamDTO.getName();
        this.location = teamDTO.getLocation();
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

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public ArrayList<Integer> getTeamroster() {
        return teamroster;
    }

    public void setTeamroster(ArrayList<Integer> teamroster) {
        this.teamroster = teamroster;
    }

    public ArrayList<Integer> getInfielders() {
        return infielders;
    }

    public void setInfielders(ArrayList<Integer> infielders) {
        this.infielders = infielders;
    }

    public ArrayList<Integer> getOutfielders() {
        return outfielders;
    }

    public void setOutfielders(ArrayList<Integer> outfielders) {
        this.outfielders = outfielders;
    }

    public ArrayList<Integer> getPitchers() {
        return pitchers;
    }

    public void setPitchers(ArrayList<Integer> pitchers) {
        this.pitchers = pitchers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addPlayerToRoster(Integer id){
        this.teamroster.add(id);
    }
    public void addPlayerToPitchers(Integer id){
        this.pitchers.add(id);
    }
    public void addPlayerToInfielders(Integer id){
        this.infielders.add(id);
    }
    public void addPlayerToOutfielders(Integer id){
        this.outfielders.add(id);
    }
    public void removePlayerFromRoster(Integer id){
        this.teamroster.remove(id);
    }
    public void removePlayerFromInfielders(Integer id){
        this.infielders.remove(id);
    }
    public void removePlayerFromPitchers(Integer id){
        this.pitchers.remove(id);
    }
    public void removePlayerFromOutfielders(Integer id){
        this.outfielders.remove(id);
    }
}
