package com.falcon.controlef.vidstate;
import com.falcon.controlef.models.Video;

public class StateTranscript implements State {
	Video video;

	StateTranscript(Video video) {
		this.video = video;
	}

	@Override
	public void stateUp() {
		System.out.println("Video transcript has finished generating. Transitioning to final stage.");
		video.state = new StateDone(video);

	}

	@Override
	public void errorEncountered() {
		System.out.println("An error has been encountered.");
		// print out the error log
		// Kill or stall the generation process
	}

	@Override
	public void printState() {
		System.out.println("Current video state: Transcript is being generated.");
		// Display percents

	}

	@Override
	public String toString() {
		return "Transcipt";
	}
}
