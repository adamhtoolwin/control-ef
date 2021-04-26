package com.falcon.controlef.service;

import com.falcon.controlef.models.TranscriptSearchResult;

public interface TranscriptService {
    TranscriptSearchResult search(String keyword);
}
