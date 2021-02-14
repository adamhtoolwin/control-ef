package com.falcon.controlef.controllers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.falcon.controlef.controllers.services.VideoService;
import com.falcon.controlef.controllers.services.VideoServiceInterface;
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
    public String uploadVideo(@RequestParam(name = "title") String title) throws ParseException{
        // Video video = new Video();
        // video.setTitle(title);

        String stringDate = "31/12/2000"; 
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate); 

        Video video = Video.builder()
				.title("Visit to Thailand")
				.keyword("Tour")
				.uploader("Daniel")
				.upload(date)
				.build();

        VideoServiceInterface vidService = new VideoService();
        boolean completed = vidService.process(video);

        System.out.println(video);
        System.out.println("Completed: " + completed);

        // facade - videoService.process(video)
        // upload to storage somewhere
        // connect with audio API
        // connect with transcript API

        return "redirect:/";
    }
}