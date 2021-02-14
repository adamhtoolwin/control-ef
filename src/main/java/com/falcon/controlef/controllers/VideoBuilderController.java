package com.example.demo.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Video;
//import com.sun.el.parser.ParseException;

@RestController
@RequestMapping("/videoBuilder")
public class VideoBuilderController {

	@GetMapping("video1")
	public String getVideo1() throws java.text.ParseException {
	
		String sDate1="31/12/2000"; 
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
		Video v1 = Video.builder()
				.title("Visit to Thailand")
				.keyword("Tour")
				.uploader("Daniel")
				.upload(date1)
				.build();
		System.out.println(v1.toString());
		return "Video Uploaded";
	}
}
