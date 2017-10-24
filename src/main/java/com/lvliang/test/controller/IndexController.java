package com.lvliang.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="/index.html")
	public String index(Model model){
		System.out.println("Coming in......");
		return "index";
	}
	
}
