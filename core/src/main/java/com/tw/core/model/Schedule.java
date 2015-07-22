package com.tw.core.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xim on 7/22/15.
 */
@Entity
@Table(name="course_times")
public class Schedule {
    private int id;
    private Course course;
    private Date date;

    public Schedule() {
    }

    public Schedule(Course course, Date date) {
        this.course = course;
        this.date = date;
    }

    public Schedule(int id, Course course, Date date) {
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

    @ManyToOne
    @JoinColumn(name = "course")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
