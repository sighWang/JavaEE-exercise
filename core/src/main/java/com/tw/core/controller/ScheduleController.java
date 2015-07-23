package com.tw.core.controller;

import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/schedules")
    public ModelAndView getSchedulesPage(){
        ModelAndView modelAndView = new ModelAndView("schedules/index");
        modelAndView.addObject("schedules", scheduleService.getSchedules());
        return modelAndView;
    }
}
