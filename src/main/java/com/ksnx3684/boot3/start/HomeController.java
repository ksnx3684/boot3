package com.ksnx3684.boot3.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String start() {
		return "index";
	}
	
	@GetMapping("/getTest")
	public String getTest(String msg) {
		System.out.println("GetTest 요청 발생");
		System.out.println("msg : " + msg);
		return "common/result";
	}
	
	@PostMapping("/postTest")
	public String postTest(String msg) {
		System.out.println("PostTest 요청 발생");
		System.out.println("msg : " + msg);
		return "common/result";
	}
	
	@PostMapping("/arrayTest")
	public String arrayTest(String msg, String[] checklist) {
		System.out.println("ArrayTest 요청 발생");
		System.out.println("msg : " + msg);
		for(String ch : checklist) {
			System.out.println(ch);
		}
		return "common/result";
	}
}
