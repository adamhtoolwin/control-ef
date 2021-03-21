package com.falcon.controlef.dao;

import com.falcon.controlef.models.Video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "videos", path = "videos")
public interface VideoDao extends JpaRepository<Video, Integer>{
    
}
