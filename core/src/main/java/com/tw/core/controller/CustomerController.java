package com.tw.core.controller;

import com.tw.core.model.Customer;
import com.tw.core.model.Employee;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/customers")
    public ModelAndView getCustomerPage() {
        ModelAndView modelAndView = new ModelAndView("customers/index");
        modelAndView.addObject("customers", customerService.getCustomers());
        return modelAndView;
    }

    @RequestMapping(value = "/customerAdd", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView("customers/add");
        modelAndView.addObject("employees", employeeService.getEmployees());
        return modelAndView;
    }

    @RequestMapping(value = "/customerAdd", method = RequestMethod.POST)
    public ModelAndView addCustomer(@RequestParam String name, String gender, int employee) {
        Customer customer = null;
        if(employee < 0) {
            customer = new Customer(name, gender);
        }else {
            customer = new Customer(name, gender, employeeService.getEmployee(employee));
        }
        customerService.addCustomer(customer);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/customerUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdatePage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customers/update");
        modelAndView.addObject("customer", customerService.getCustomer(id));
        modelAndView.addObject("employees", employeeService.getEmployees());
        return modelAndView;
    }

    @RequestMapping(value = "/customerUpdate", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam int id, int number, String name, String gender, int employee) {
        Customer customer = null;
        if(employee < 0) {
            customer = new Customer(id, number, name, gender);
        }else {
            customer = new Customer(id, number, name, gender, employeeService.getEmployee(employee));
        }
        customerService.update(customer);

        return new ModelAndView("redirect:/customers");
    }
}
