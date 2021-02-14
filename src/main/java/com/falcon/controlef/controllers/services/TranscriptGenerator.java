package com.falcon.controlef.controllers.services;

import com.falcon.controlef.models.Video;

public class TranscriptGenerator implements VideoProcessingChain {
    private VideoProcessingChain chain;

    @Override
    public void setNextProcessor(VideoProcessingChain nextChain) {
        this.chain = nextChain;

    }

    @Override
    public void process(Video video) {
        System.out.println("Generating transcript...");
    }
    
}
