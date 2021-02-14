package com.falcon.controlef.decorator;

public class TestingDecorator {

	public static void main(String[] args) {
		
		TaggedVideo taggedVideo = new BasicVideo();
		String b = taggedVideo.printTag();
		
		DegreeDecorator degree = new DegreeDecorator(taggedVideo);
		String a = degree.printTag();
		
		VidTypeDecorator type = new VidTypeDecorator(taggedVideo);
		String c = type.printTag();
		
		HostDecorator host = new HostDecorator(taggedVideo);
		String d = host.printTag();
		
		System.out.println(a + " " + b + " " + c + " by " + d);

	}

}
