package com.falcon.controlef.controllers;

import java.util.List;

import com.falcon.controlef.dao.UserDao;
import com.falcon.controlef.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserDao uDao;

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
        mv.addObject("page", "Admin Dashboard");
        List<User> userList = uDao.findAll();

        // TODO
        // Add User role logic here
        mv.addObject("admin_flag", true);
        mv.addObject("users", userList);

        return mv;
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login.jsp";
    }

    @GetMapping(path = "/logout-success")
    public String logout() {
        return "home.jsp";
    }
}
