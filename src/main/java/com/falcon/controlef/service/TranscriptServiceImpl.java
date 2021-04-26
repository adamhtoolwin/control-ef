package com.falcon.controlef.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.falcon.controlef.controllers.services.TranscriptGenerator;
import com.falcon.controlef.dao.TranscriptDao;
import com.falcon.controlef.dao.VideoDao;
import com.falcon.controlef.models.Transcript;
import com.falcon.controlef.models.TranscriptSearchResult;
import com.falcon.controlef.models.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService{
    @Autowired
    TranscriptDao transcriptDao;

    @Autowired
    VideoDao videoDao;

    @Override
    public TranscriptSearchResult search(String keyword) {
        List<Transcript> transcriptList = transcriptDao.findByContentContainingIgnoreCaseOrderByStartTimeAsc(keyword);

        List<Transcript> transcripts = transcriptDao.findByContentContainingIgnoreCaseOrderByStartTimeAsc(keyword);

        // System.out.println(transcriptList);
        Set<Video> videos = new HashSet<>();

        for (Transcript transcript: transcriptList) {
            String videoID = transcript.getVideo().getId();
            videos.add(videoDao.findById(videoID).get());
            
            System.out.println(transcript.getVideo().getTitle());
        }

        return new TranscriptSearchResult(videos, transcripts);
        
    }
    
}
