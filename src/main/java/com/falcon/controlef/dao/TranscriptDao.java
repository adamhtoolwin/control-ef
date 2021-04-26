package com.falcon.controlef.dao;

import java.util.List;

import com.falcon.controlef.models.Transcript;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "transcripts", path = "transcripts")
public interface TranscriptDao extends JpaRepository<Transcript, Integer>{
    List<Transcript> findByContentContainingIgnoreCase(String content);
}
