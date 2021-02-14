package com.falcon.controlef.controllers.services;

import com.falcon.controlef.models.Video;

public class VideoProcessor {
    private VideoProcessingChain c1;

    public VideoProcessor() {

        this.c1 = new VideoUploader();
        VideoProcessingChain c2 = new TranscriptGenerator();
        c1.setNextProcessor(c2);
    }

    public void beginProcessing(Video video){
        this.c1.process(video);
        this.c1.getChain().process(video);
    }
}
