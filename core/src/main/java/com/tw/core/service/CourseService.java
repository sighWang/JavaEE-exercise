package com.tw.core.service;

import com.tw.core.dao.CourseDao;
import com.tw.core.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
