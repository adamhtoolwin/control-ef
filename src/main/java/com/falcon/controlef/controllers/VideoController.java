package com.falcon.controlef.controllers;

import com.falcon.controlef.models.Video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VideoController {
    @GetMapping("/")
    public String home() {
        return "home.jsp";
    }

    @PostMapping("/videos/upload")
    public String uploadVideo(@RequestParam(name = "title") String title ){
        System.out.println(title);
        // facade - videoService.process(video)
        // upload to storage somewhere
        // connect with audio API
        // connect with transcript API

        return "redirect:/";
    }
}