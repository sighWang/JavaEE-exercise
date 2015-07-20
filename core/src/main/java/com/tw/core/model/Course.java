package com.tw.core.model;

/**
 * Created by xim on 7/17/15.
 */


import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name ="courses")
public class Course {

    private int id;
    private String name;
    private String describe;
    private Set customers;


//    private Coach coach;
    private Set courses;

    public Set getCourses() {
        return courses;
    }

    public void setCourses(Set courses) {
        this.courses = courses;
    }


    public Course() {
    }

    @Id
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

//    public Coach getCoach() {
//        return coach;
//    }

//    public void setCoach(Coach coach) {
//        this.coach = coach;
//    }

//    @ManyToMany
//    @JoinTable(name="course_customers",
//    joinColumns = @JoinColumn(name = "course"),
//    inverseJoinColumns = @JoinColumn(name = "custom"))
    public Set getCustomers() {
        return customers;
    }

    public void setCustomers(Set customers) {
        this.customers = customers;
    }
}
