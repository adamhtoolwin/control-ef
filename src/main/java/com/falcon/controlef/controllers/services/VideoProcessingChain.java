package com.falcon.controlef.controllers.services;

import com.falcon.controlef.models.Video;

public interface VideoProcessingChain {
    void setNextProcessor(VideoProcessingChain nextChain);
    void process(Video video);
	VideoProcessingChain getChain();
}