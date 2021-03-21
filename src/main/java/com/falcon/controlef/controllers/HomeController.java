package com.falcon.controlef.controllers;

import java.security.Principal;

import com.falcon.controlef.models.User;
import com.falcon.controlef.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public ModelAndView home(Principal principal) {
        ModelAndView mv = new ModelAndView("home.jsp");
        User user = userService.findByUsername(principal.getName());
        mv.addObject("user", user);

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
}
