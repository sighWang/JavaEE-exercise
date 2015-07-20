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
    private Set<Customer> customers;


//    private Coach coach;

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

    @ManyToMany
    @JoinTable(name="course_customers",
    joinColumns = @JoinColumn(name = "course"),
    inverseJoinColumns = @JoinColumn(name = "custom"))
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
