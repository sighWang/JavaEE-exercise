package com.tw.core.controller;

import com.tw.core.model.Employee;
import com.tw.core.model.User;
import com.tw.core.service.EmployeeService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("employees");
//        modelAndView.addObject("employees", employeeService.getEmployees());
//        return employeeService.getEmployees();
//        List<Employee> employees = employeeService.getEmployees();
//        JSONSerializer serializer = new JSONSerializer().include("employee");
//
//        return serializer.serialize(employees);

        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/employeeUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdatePage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employeeUpdate");
        modelAndView.addObject("employee", employeeService.getEmployee(id));
        return modelAndView;
    }

    @RequestMapping(value = "/employeeUpdate", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@RequestParam int id, String name, String gender, String role) {
        Employee employee = new Employee(id, name, gender, role);
        employeeService.update(employee);
        return new ModelAndView("redirect:/employees");
    }

    @RequestMapping(value = "/employeeDelete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/employees");
    }


}
