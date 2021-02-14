package com.falcon.controlef.decorator;

public class BasicVideo implements TaggedVideo {

	@Override
	public String printTag() {
		return "Machine Learning"; //later this will become a variable

	}
}
