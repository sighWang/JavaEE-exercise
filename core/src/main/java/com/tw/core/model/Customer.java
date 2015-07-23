package com.tw.core.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    private int id;
    private int number;
    private String name;
    private String gender;
    private Employee employee;
    private Set<Course> courses;

    private  static int beginNumber = 12;

    public Customer() {
    }

    public Customer(Set<Course> courses, Employee coach, String gender, String name, int number) {
        this.courses = courses;
        this.employee = coach;
        this.gender = gender;
        this.name = name;
        this.number = number;
    }

    public Customer(int id, int number, String name, String gender, Employee coach, Set<Course> courses) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.employee = coach;
        this.courses = courses;
    }

    public Customer(int number, String name, String gender, Employee coach) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.employee = coach;
    }

    public Customer(String name, String gender) {
        this.number = beginNumber++;
        this.name = name;
        this.gender = gender;
    }

    public Customer(String name, String gender, Employee employee) {
        this.number = beginNumber++;
        this.name = name;
        this.gender = gender;
        this.employee = employee;
    }

    @ManyToMany(mappedBy = "customers")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
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

    @ManyToOne
    @JoinColumn(name = "coach")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee coach) {
        this.employee = coach;
    }
}
