package com.tw.core.model;

import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    private int id;
    private String name;
    private String describes;
    private Set<Customer> customers;
    private Set<Schedule> schedules;
    private Employee employee;

    public Course() {
    }

    public Course(String name, String describes, Set<Customer> customers) {
        this.name = name;
        this.describes = describes;
        this.customers = customers;
    }

    public Course(int id, String name, String describes, Set<Customer> customers) {
        this.id = id;
        this.name = name;
        this.describes = describes;
        this.customers = customers;
    }

    public Course(String name, String describes, Employee employee) {
        this.name = name;
        this.describes = describes;
        this.employee = employee;
    }

    public Course(int id, String name, String describes, Employee employee) {
        this.id = id;
        this.name = name;
        this.describes = describes;
        this.employee = employee;
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    @ManyToOne
    @JoinColumn(name = "coach")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToMany()
    @JoinTable(name = "course_customers",
            joinColumns = {@JoinColumn(name = "course")},
            inverseJoinColumns = {@JoinColumn(name = "customer")})
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @OneToMany(mappedBy = "course")
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describes='" + describes + '\'' +
                ", customers=" + customers +
                ", schedules=" + schedules +
                ", employee=" + employee +
                '}';
    }
}
