package com.tw.core.service;

import com.tw.core.dao.CourseDao;
import com.tw.core.model.Course;
import com.tw.core.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ScheduleService scheduleService;

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
        Schedule schedule = new Schedule(courseDao.getCourse(id), date);
        scheduleService.addSchedule(schedule);
        course.addSchedule(schedule);
        courseDao.update(course);
    }
}
