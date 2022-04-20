package com.ksnx3684.boot3.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("index")
	public String start() {
		return "index";
	}
}
