package com.falcon.controlef.vidstate;

public interface State {
	void stateUp();

	void errorEncountered();

	void printState();

	String toString();
}
