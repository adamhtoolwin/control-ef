package com.falcon.controlef.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import com.falcon.controlef.controllers.services.VideoProcessor;
import com.falcon.controlef.controllers.services.VideoService;
import com.falcon.controlef.controllers.services.VideoServiceInterface;
import com.falcon.controlef.dao.TranscriptDao;
import com.falcon.controlef.dao.VideoDao;
import com.falcon.controlef.models.Video;
import com.falcon.controlef.service.TranscriptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VideoController {
    @Autowired
    private TranscriptDao transcriptDao;

    @Autowired
    private VideoDao videoDao;

    @Autowired
    private TranscriptService transcriptService;
    
    @GetMapping("/videos/upload")
    public String upload() {
        return "/upload.jsp";
    }

    @PostMapping("/videos/search")
    public ModelAndView search(Principal principal, @RequestParam("search") String search) {
        ModelAndView mv = new ModelAndView("/searchResult.jsp");
        Set<Video> videos = transcriptService.search(search);

        for (Video video: videos) {            
            System.out.println(video.getTitle());
        }
        
        mv.addObject("videos", videos);

        return mv;
    }

    @GetMapping("/video/{id}")
    public ModelAndView getVideo(Principal principal, @PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("/viewVideo.jsp");
        Optional<Video> optionalVideo = videoDao.findById(id);

        Video video = optionalVideo.get();
        mv.addObject("video", video);

        return mv;
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
        System.out.println("Completed: " + completed);

        System.out.println(video);

        // facade - videoService.process(video)
        // upload to storage somewhere
        // connect with audio API
        // connect with transcript API

        return "redirect:/";
    }

    @PostMapping("/videos/cor-upload") 
    public String uploadVideoCOR(@RequestParam(name = "title") String title) throws ParseException{
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

        VideoProcessor processor = new VideoProcessor();
        processor.beginProcessing(video);

        System.out.println(video);

        // facade - videoService.process(video)
        // upload to storage somewhere
        // connect with audio API
        // connect with transcript API

        return "redirect:/";
    }
}