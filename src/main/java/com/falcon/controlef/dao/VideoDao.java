package com.falcon.controlef.dao;

import java.util.List;

import com.falcon.controlef.models.Tag;
import com.falcon.controlef.models.Video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "videos", path = "videos")
public interface VideoDao extends JpaRepository<Video, String>{
    List<Video> findByTags(Tag tag);
}
