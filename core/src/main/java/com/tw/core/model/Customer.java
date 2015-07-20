package com.tw.core.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xim on 7/17/15.
 */
@Entity
@Table(name = "customers")
public class Customer {
    private int id;
    private int number;
    private String name;
    private String gender;


    private Coach coach;
    private Set courses;

    public Customer() {
    }

    public Customer(Set courses, Coach coach, String gender, String name, int number) {
        this.courses = courses;
        this.coach = coach;
        this.gender = gender;
        this.name = name;
        this.number = number;
    }

    public Customer(int id, int number, String name, String gender, Coach coach, Set courses) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.coach = coach;
        this.courses = courses;
    }

    public Customer(int number, String name, String gender, Coach coach) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.coach = coach;
    }

    //    @ManyToMany(mappedBy = "customers")
    public Set getCourses() {
        return courses;
    }

    public void setCourses(Set courses) {
        this.courses = courses;
    }



    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    @ManyToOne
//    @JoinColumn(name = "coach_id")
    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
