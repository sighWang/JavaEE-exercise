package com.tw.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xim on 7/22/15.
 */
@RestController
public class IndexController {
    @RequestMapping
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }
}
