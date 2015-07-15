package com.tw.core;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name, String sex, String email, int age, String password) {
        System.out.println("/web/userAdd");
        userService.addUser(new User(name, sex, email, age, MD5Util.md5(password)));
        return new ModelAndView("redirect:/");
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
        userService.updateUser(new User(id, name, sex, email, age, password));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.GET)
    public ModelAndView getAddPage () {
        return new ModelAndView("add");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage (HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("u", "u");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login (@RequestParam String name, String password, HttpServletRequest request, HttpServletResponse response) {

        User user = userService.login(name);
        if(MD5Util.md5(password).equals(user.getPassword())) {
            request.getSession().setAttribute("user", user);
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("redirect:/login");
    }
}
