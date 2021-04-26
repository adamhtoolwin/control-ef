package com.falcon.controlef.controllers;

import java.security.Principal;
import java.util.List;

import com.falcon.controlef.dao.TagDao;
import com.falcon.controlef.dao.VideoDao;
import com.falcon.controlef.models.Tag;
import com.falcon.controlef.models.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TagController {
    @Autowired
    private VideoDao videoDao;

    @Autowired
    private TagDao tagDao;

    @PostMapping("/videos/searchByTag")
    public ModelAndView searchByTag(Principal principal, @RequestParam("tag") int id) {
        ModelAndView mv = new ModelAndView("/searchResultTag.jsp");
        Tag tag = tagDao.findById(id).get();

        List<Video> videos = videoDao.findByTags(tag);

        mv.addObject("videos", videos);
        return mv;
    }
}
