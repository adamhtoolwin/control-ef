package com.falcon.controlef.vidstate;

public class StateDone implements State {
	Video video;

	StateDone(Video video) {
		this.video = video;
	}

	@Override
	public void stateUp() {
		System.out.println("The video is ready. No more higher states are available.");

	}

	@Override
	public void errorEncountered() {
		System.out.println("An error has been encountered.");
		// print out the error log
	}

	@Override
	public void printState() {
		System.out.println("Current video state: The video is ready to be used.");

	}
}
