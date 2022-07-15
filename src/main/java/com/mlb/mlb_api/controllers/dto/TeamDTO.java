package com.mlb.mlb_api.controllers.dto;


public class TeamDTO {
    private String name;
    private String location;


    public TeamDTO(String name, Double budget, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
