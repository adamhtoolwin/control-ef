package com.falcon.controlef.vidstate;

public class Video {
	State state; //the class can have a state

	public Video() {
		// state = new StateNull();
	}

	// if ( the video state number goes up )
	public void stateUp() {
		state.stateUp();
	}

	// if ( an error is encountered in the database or other processes)
	public void errorEncountered() {
		state.errorEncountered();
	}

	public void printState() {
		state.printState();
	}
}
