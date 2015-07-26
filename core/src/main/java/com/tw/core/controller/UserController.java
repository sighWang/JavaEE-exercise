package com.tw.core.controller;

import com.tw.core.model.Employee;
import com.tw.core.model.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import com.tw.core.util.MD5Util;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/users/user/{id}", method = RequestMethod.POST)
    public String getUpdateView(@PathVariable int id) {
        User user = userService.getUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userUpdate");
        user.setPassword(MD5Util.md5(user.getPassword()));
        modelAndView.addObject("user", user);
        modelAndView.addObject("employees", employeeService.getEmployees());
        return "userAdd";
    }

    @RequestMapping(value = "/users/user/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", userService.getUsers());
        modelAndView.addObject("employees", employeeService.getEmployees());
        return modelAndView;
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        ModelAndView modelAndView = new ModelAndView("userAdd");
        modelAndView.addObject("employees", employeeService.getEmployees());
        return modelAndView;
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name, String password, int employee) {
        userService.addUser(new User(name, MD5Util.md5(password), employeeService.getEmployee(employee)));
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/employeeAdd", method = RequestMethod.GET)
    public ModelAndView getEmployeeAddPage() {
        return new ModelAndView("employeeAdd");
    }

    @RequestMapping(value = "/employeeAdd", method = RequestMethod.POST)
    public ModelAndView addEmployee(@RequestParam String name, String gender, String role) {
        employeeService.addEmployee(new Employee(name, gender, role));
        return new ModelAndView("redirect:employeeAdd");
    }


    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/userUpdate/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userUpdate");
        user.setPassword(MD5Util.md5(user.getPassword()));
        modelAndView.addObject("user", user);
        modelAndView.addObject("employees", employeeService.getEmployees());
        return modelAndView;
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam int id, String name, String password, int employee) {
        userService.updateUser(new User(id, name, password, employeeService.getEmployee(employee)));
        return new ModelAndView("redirect:/users");
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String name, String password, HttpServletRequest request, HttpServletResponse response) {

        User user = userService.login(name);
        String viewName = "/";
        if (MD5Util.md5(password).equals(user.getPassword())) {
            request.getSession().setAttribute("loginUser", user);
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("previousPage")) {
                    viewName = cookie.getValue();
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                return new ModelAndView("redirect:" + viewName);
            }
        }
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("loginUser");
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/testOneToOne", method = RequestMethod.GET)
    public ModelAndView testOneToOne(HttpServletRequest request, HttpServletResponse response) {
        userService.testOneToOne();
        return new ModelAndView("redirect:/login");
    }
}
