package com.hotv.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="/index.html")
	public String index(Model model,HttpServletRequest request){
		model.addAttribute("val", "hello spring boot!");
		return "index";
	}
	
}
