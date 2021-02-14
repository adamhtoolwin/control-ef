package com.falcon.controlef.controllers.services;

import com.falcon.controlef.models.Video;

import org.springframework.stereotype.Component;

@Component
public class VideoService implements VideoServiceInterface {
    public boolean process(Video video) {
        boolean complete = true;

        video.stateUp();
        video.stateUp();
        video.stateUp();
        video.stateUp();

        return complete;
    }
}
