package com.mlb.mlb_api.controllers.dto;


public class PlayerDTO {

    private String name;
    private Integer age;
    private Double cost;
    private String position;


    public PlayerDTO(String name, Integer age, Double cost, String position) {
        this.name = name;
        this.age = age;
        this.cost = cost;
        this.position = position;
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

}
