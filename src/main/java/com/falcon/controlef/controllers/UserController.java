package com.falcon.controlef.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home.jsp");

        // TODO
        // Add User role logic here
        mv.addObject("admin_flag", true);

        return mv;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView("admin.jsp");

        // TODO
        // Add User role logic here
        mv.addObject("admin_flag", true);

        return mv;
    }
}
