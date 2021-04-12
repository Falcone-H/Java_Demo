package com.example.MVC.Bean;

public class User {
    public String id;
    public String name;
    public School school;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public User(String id, String name, School school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }
}
