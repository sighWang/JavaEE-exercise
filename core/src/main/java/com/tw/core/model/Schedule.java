package com.tw.core.model;

import javax.persistence.*;

@Entity
@Table(name="course_times")
public class Schedule {
    private int id;
    private Course course;
    private String date;
    private Customer customer;

    public Schedule() {
    }

    public Schedule(Course course, String date) {
        this.course = course;
        this.date = date;
    }

    public Schedule(int id, Course course, String date) {
        this.id = id;
        this.course = course;
        this.date = date;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", course=" + course +
                ", date='" + date + '\'' +
                ", customer=" + customer +
                '}';
    }
}
