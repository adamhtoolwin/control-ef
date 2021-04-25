package com.falcon.controlef.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Transcript { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int startTime;

    private int endTime;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
	private Video video;
}
