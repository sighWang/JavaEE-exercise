package com.tw.core.controller;

import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xim on 7/21/15.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public ModelAndView getCourses() {
        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("courses", courseService.getCourses());
        return modelAndView;
    }
}
