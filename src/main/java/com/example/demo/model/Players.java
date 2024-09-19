package com.example.demo.model;

public class Players {

    private int id;
    private String firstName;
    private String lastName;

    private String team;

    public Players(int id, String firstName, String lastName, String team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Players{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
