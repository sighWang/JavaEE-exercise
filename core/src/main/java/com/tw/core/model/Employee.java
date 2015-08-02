package com.tw.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    public int id;
    public String name;
    public String gender;
    public String role;

    public Employee() {
    }

    public Employee(String name, String gender, String role) {
        this.name = name;
        this.gender = gender;
        this.role = role;
    }

    public Employee(int id, String name, String gender, String role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String
    toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
