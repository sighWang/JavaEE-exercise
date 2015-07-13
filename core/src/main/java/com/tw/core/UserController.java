package com.tw.core;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by xim on 7/13/15.
 */

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");

        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name, String sex, String email, int age) {
        System.out.println("/web/userAdd");
        userService.addUser(new User(name, sex, email, age));
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
    public ModelAndView updateUser(@RequestParam int id, String name, String sex, String email, int age) {
        userService.updateUser(new User(id, name, sex, email, age));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.GET)
    public ModelAndView getAddPage () {
        return new ModelAndView("add");
    }
}
