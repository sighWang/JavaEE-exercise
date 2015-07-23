package com.tw.core.controller;

import com.tw.core.model.Course;
import com.tw.core.model.Schedule;
import com.tw.core.service.CourseService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getCourses() {
        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("courses", courseService.getCourses());
        return modelAndView;
    }

    @RequestMapping(value = "courseAdd", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView("courseAdd");
        modelAndView.addObject("employees", employeeService.getEmployees());
        return modelAndView;
    }

    @RequestMapping(value = "courseAdd", method = RequestMethod.POST)
    public ModelAndView addCustom(@RequestParam String name, String describes, int employee) {
        courseService.addCourse(new Course(name, describes, employeeService.getEmployee(employee)));
        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "courseUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdatePage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("courseUpdate");
        modelAndView.addObject("course", courseService.getCourse(id));
        modelAndView.addObject("employees", employeeService.getEmployees());
        return modelAndView;
    }

    @RequestMapping(value = "courseUpdate", method = RequestMethod.POST)
    public ModelAndView updateCourse(@RequestParam int id, String name, String describes, int employee) {
        courseService.update(new Course(id, name, describes, employeeService.getEmployee(employee)));
        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "courseDelete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable int id) {
        courseService.delete(courseService.getCourse(id));
        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "dateAdd/{id}", method = RequestMethod.GET)
    public ModelAndView getDateAddPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("courseDateAdd");
        modelAndView.addObject("course", courseService.getCourse(id));
        return modelAndView;
    }

    @RequestMapping(value = "/dateAdd", method = RequestMethod.POST)
    public ModelAndView addDate(@RequestParam int id, String date) {
        courseService.addCourseDate(id, date);
        return new ModelAndView("redirect:courses");
    }

    @RequestMapping(value = "/courseDates/{id}",method = RequestMethod.GET)
    public ModelAndView getCourseDatesPage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("courseSchedules");
        Course course = courseService.getCourse(id);
        Set<Schedule> schedules = course.getSchedules();
        modelAndView.addObject("course", course);
        modelAndView.addObject("schedules", schedules);
        return modelAndView;
    }
}
