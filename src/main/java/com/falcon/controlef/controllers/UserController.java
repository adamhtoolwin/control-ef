package com.falcon.controlef.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import com.falcon.controlef.dao.UserDao;
import com.falcon.controlef.models.User;
import com.falcon.controlef.service.UserService;
import com.falcon.controlef.validation.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserDao uDao;
    
    @Autowired
    private UserValidator userValidator;

    @GetMapping(path = "/login")
    public String login() {
        return "login.jsp";
    }

    @GetMapping(path = "/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register.jsp";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()){
            return "register.jsp";
        }

        userService.save(user);

        return "login.jsp";
    }

    @GetMapping(path = "/logout-success")
    public String logout() {
        return "redirect:/";
    }
}
