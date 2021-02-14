package com.falcon.controlef.decorator;

public class DegreeDecorator extends VideoDecorator {

	public DegreeDecorator(TaggedVideo taggedVideo) {
		super(taggedVideo);
	}

	@Override
	public String printTag() {
		super.printTag();
		return "Phd"; //later this will become a variable
	}

}