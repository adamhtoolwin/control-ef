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

    @GetMapping("/")
    public ModelAndView home(Principal principal) {
        ModelAndView mv = new ModelAndView("home.jsp");
        // User user = userService.findByUsername(principal.getName());
        // mv.addObject("user", user);

        // for (Role role: user.getRoles()) {
        //     if (role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
        //         System.out.println("Current user is " + role.getName());
        //         mv.addObject("admin_flag", true);
        //     }
        //     if (role.getName().equalsIgnoreCase("ROLE_USER")) {
        //         System.out.println("Current user is " + role.getName());
        //     }
        //     if (role.getName().equalsIgnoreCase("ROLE_PREMIUM_USER")) {
        //         System.out.println("Current user is " + role.getName());
        //     }
        // }
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
        return "home.jsp";
    }
}
