package com.falcon.controlef.controllers;

import java.security.Principal;
import java.util.List;

import com.falcon.controlef.dao.UserDao;
import com.falcon.controlef.models.User;
import com.falcon.controlef.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserDao uDao;
    
    @GetMapping("/admin")
    public ModelAndView admin(Principal principal) {

        ModelAndView mv = new ModelAndView("admin.jsp");
        User user = userService.findByUsername(principal.getName());
        mv.addObject("user", user);
        
        mv.addObject("page", "Admin Dashboard");
        List<User> userList = uDao.findAll();

        mv.addObject("admin_flag", true);
        mv.addObject("users", userList);

        return mv;
    }
}
