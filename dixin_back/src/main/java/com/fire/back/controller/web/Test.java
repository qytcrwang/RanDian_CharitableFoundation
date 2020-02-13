package com.fire.back.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {


	@RequestMapping("/test1")
	public String test1() {
		return "index";
	}
	
}
