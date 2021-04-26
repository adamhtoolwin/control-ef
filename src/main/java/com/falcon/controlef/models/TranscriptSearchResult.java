package com.falcon.controlef.models;

import java.util.List;
import java.util.Set;

public class TranscriptSearchResult {
    private final Set<Video> videos;
    private final List<Transcript> transcripts;

    public TranscriptSearchResult(Set<Video> videos, List<Transcript> transcripts) {
        this.videos = videos;
        this.transcripts = transcripts;
    }

    public Set<Video> getVideos() {
        return videos;
    }
    
    public List<Transcript> getTranscripts() {
        return transcripts;
    }
}
