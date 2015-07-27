package com.tw.core.controller;

import com.tw.core.model.Schedule;
import com.tw.core.service.CourseService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "schedules/schedule/{id}", method = RequestMethod.DELETE)
    public String deleteSchedule(@PathVariable int id){
        scheduleService.delete(id);
        return "schedules";
    }

    @RequestMapping(value = "schedules/schedule/{id}", method = RequestMethod.PUT)
    public String updateSchedule(@PathVariable int id){
        scheduleService.delete(id);
        return "schedules";
    }
    @RequestMapping(value = "/schedules")
    public ModelAndView getSchedulesPage(){
        ModelAndView modelAndView = new ModelAndView("schedules/index");
        modelAndView.addObject("schedules", scheduleService.getSchedules());
        return modelAndView;
    }

    @RequestMapping(value = "/scheduleAdd")
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView("schedules/add");
        modelAndView.addObject("courses", courseService.getCourses());
        modelAndView.addObject("customer", customerService.getCustomers());
        return modelAndView;
    }

    @RequestMapping(value = "/scheduleAdd", method = RequestMethod.POST)
    public ModelAndView addSchedule(@RequestParam int course, String date) {
        scheduleService.addSchedule(new Schedule(courseService.getCourse(course), date));
        return new ModelAndView("redirect:/schedules");
    }

    @RequestMapping(value = "/schedules/schedule/{id}", method = RequestMethod.POST)
    public String updateScheduleView(@PathVariable int id){
        return "page";
    }

}
