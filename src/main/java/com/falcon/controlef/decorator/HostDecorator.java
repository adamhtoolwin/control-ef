package com.falcon.controlef.decorator;

public class HostDecorator extends VideoDecorator {

	public HostDecorator(TaggedVideo taggedVideo) {
		super(taggedVideo);
	}

	@Override
	public String printTag() {
		super.printTag();
		return "Lecturer Matthew"; //later this will become a variable
	}

}
