package com.falcon.controlef.decorator;

public class VidTypeDecorator extends VideoDecorator {

	public VidTypeDecorator(TaggedVideo taggedVideo) {
		super(taggedVideo);
	}

	@Override
	public String printTag() {
		super.printTag();
		return "Laboratory work"; //later this will become a variable
	}

}
