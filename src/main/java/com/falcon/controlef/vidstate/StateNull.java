package com.falcon.controlef.vidstate;
import com.falcon.controlef.models.Video;

public class StateNull implements State {

	Video video; //???

	public StateNull(Video video) {
		this.video = video;
	}

	@Override
	public void stateUp() {
		System.out.println("Video started uploading");
		video.state = new StateUpload(video);

	}

	@Override
	public void errorEncountered() {
		System.out.println("An error has been encountered.");
		// print out the error log
	}

	@Override
	public void printState() {
		System.out.println("Current video state: being prepared for uploading.");

	}

	@Override
	public String toString() {
		return "Null";
	}
}
