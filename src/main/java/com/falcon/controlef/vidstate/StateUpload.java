package com.falcon.controlef.vidstate;

public class StateUpload implements State {

	Video video;

	StateUpload (Video video) {
	this.video = video;
	}//???
	@Override
	public void stateUp() {
		System.out.println("Video has finished uploading. Transitioning to transcript generation.");
		video.state = new StateTranscript(video);

	}

	@Override
	public void errorEncountered() {
		System.out.println("An error has been encountered.");
		// print out the error log
		// Kill or stall the uploading process
	}

	@Override
	public void printState() {
		System.out.println("Current video state: Uploading");
		// Display percents

	}

}
