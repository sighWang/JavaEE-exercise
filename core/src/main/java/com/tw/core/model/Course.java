package com.tw.core.model;

/**
 * Created by xim on 7/17/15.
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table( name ="courses")
public class Course {

    private int id;
    private String name;
    private String describe;
    private Set customers;


    private Coach coach;


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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set getCustomers() {

        return customers;
    }

    public void setCustomers(Set customers) {
        this.customers = customers;
    }
}
