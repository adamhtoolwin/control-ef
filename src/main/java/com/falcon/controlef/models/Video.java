package com.falcon.controlef.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.falcon.controlef.vidstate.State;
import com.falcon.controlef.vidstate.StateNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Video {
	
	@Id
	private String id;
	
	private String title;		//Title of the video file
	
	private String keyword;		//Keyword/tags
	
	private LocalDate uploadDate;		//Date the video uploaded

	@Column(nullable = false)
	private String link;

    private String status;

    @Transient
	public State state;

    @Builder
    public Video(int id, String title, String keyword, Date upload, String uploader, String status) {
		state = new StateNull(this);
	}

	// if ( the video state number goes up )
	public void stateUp() {
		state.stateUp();
        this.status = state.toString();
	}

	// if ( an error is encountered in the database or other processes)
	public void errorEncountered() {
		state.errorEncountered();
	}

	public void printState() {
		state.printState();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Transcript> transcripts;
}
