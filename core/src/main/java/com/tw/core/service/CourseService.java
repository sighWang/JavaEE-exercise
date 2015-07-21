package com.tw.core.service;

import com.tw.core.dao.CourseDao;
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
}
