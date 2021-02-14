package com.falcon.controlef.decorator;

public class VideoDecorator implements TaggedVideo {
	public TaggedVideo taggedVideo;

	public VideoDecorator(TaggedVideo taggedVideo) {
		this.taggedVideo = taggedVideo;
	}

	@Override
	public String printTag() {
		return this.taggedVideo.printTag();
	}

}
