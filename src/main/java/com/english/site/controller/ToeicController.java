package com.english.site.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToeicController {

	@GetMapping("/toeic")
	public String showToeicPage() {
		return "toeic/index";
	}
	
	@GetMapping("/toeic/part1")
	public String showToeicPart1() {
		return "toeic/part1";
	}
	
	@GetMapping("/toeic/part2")
	public String showToeicPart2() {
		return "toeic/part2";
	}
	
	@GetMapping("/toeic/part3")
	public String showToeicPart3() {
		return "toeic/part3";
	}
	
	@GetMapping("/toeic/part4")
	public String showToeicPart4() {
		return "toeic/part4";
	}
	
	@GetMapping("/toeic/part5")
	public String showToeicPart5() {
		return "toeic/part5";
	}
	
	@GetMapping("/toeic/part6")
	public String showToeicPart6() {
		return "toeic/part6";
	}
	
	@GetMapping("/toeic/part7")
	public String showToeicPart7() {
		return "toeic/part7";
	}

}
