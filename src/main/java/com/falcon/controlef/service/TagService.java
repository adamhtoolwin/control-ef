package com.falcon.controlef.service;

import java.util.Set;

import com.falcon.controlef.models.Tag;
import com.falcon.controlef.models.Video;

public interface TagService {
    Set<Video> search(Tag tag);
}
