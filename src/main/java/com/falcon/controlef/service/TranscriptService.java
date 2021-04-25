package com.falcon.controlef.service;

import java.util.Set;

import com.falcon.controlef.models.Video;

public interface TranscriptService {
    Set<Video> search(String keyword);
}
