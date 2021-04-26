package com.falcon.controlef.dao;

import com.falcon.controlef.models.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tags", path = "tags")
public interface TagDao extends JpaRepository<Tag, Integer>{
    Tag findByNameContainingIgnoreCase(String name);
}
