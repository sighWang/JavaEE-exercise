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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }
    @RequestMapping(value = "/userAdd", method = RequestMethod.GET)
    public ModelAndView getAddPage() {
        return new ModelAndView("userAdd");
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name, String password) {
        userService.addUser(new User(name,MD5Util.md5(password)));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/employeeAdd", method = RequestMethod.GET)
    public ModelAndView getEmployeeAddPage() {
        return new ModelAndView("employeeAdd");
    }

    @RequestMapping(value = "/employeeAdd", method = RequestMethod.POST)
    public ModelAndView addEmployee(@RequestParam String name, String gender, String role) {
//        userService.addUser(new User(name, sex, email, age, MD5Util.md5(password)));
        employeeService.addEmployee(new Employee(name, gender, role));
        return new ModelAndView("redirect:employeeAdd");
    }



    @RequestMapping(value = "/userDelete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int userId) {
        userService.deleteUser(userId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam int userId) {
        User user = userService.getUser(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam int id, String name, String sex, String email, int age, String password) {
//        userService.updateUser(new User(id, name, sex, email, age, password));
        return new ModelAndView("redirect:/");
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String name, String password, HttpServletRequest request, HttpServletResponse response) {

        User user = userService.login(name);
        String viewName = "/";
        if (password.equals(user.getPassword())) {
//            if (MD5Util.md5(password).equals(user.getPassword())) {
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
