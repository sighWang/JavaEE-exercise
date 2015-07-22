package com.tw.core.service;

import com.tw.core.dao.CourseDao;
import com.tw.core.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by xim on 7/21/15.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;


    public List getCourses() {
        return courseDao.getCourses();
    }

    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    public Course getCourse(int id) {
        return courseDao.getCourse(id);
    }

    public void update(Course course) {
        courseDao.update(course);
    }

    public void delete(Course course) {
        courseDao.delete(course);
    }

    public void addCourseDate(int id, String date) {
        Course course = courseDao.getCourse(id);
        course.addSchedule(new Date(date));
        System.out.printf(String.valueOf(new Date(date)));
        courseDao.update(course);
    }
}
