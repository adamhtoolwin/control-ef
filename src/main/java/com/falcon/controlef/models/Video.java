package com.falcon.controlef.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.falcon.controlef.vidstate.State;
import com.falcon.controlef.vidstate.StateNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;		//Title of the video file
	
	private String keyword;		//Keyword/tags
	
	private LocalDateTime uploadDate;		//Date the video uploaded

	private String lecturer;

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

}
