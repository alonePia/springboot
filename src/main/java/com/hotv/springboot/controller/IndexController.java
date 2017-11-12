package com.hotv.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotv.springboot.entity.SysUser;
import com.hotv.springboot.mapper.SysUserMapper;

@Controller
public class IndexController {
	Logger logger = Logger.getLogger(IndexController.class);
	
	@Autowired
	private SysUserMapper userMapper;

	@RequestMapping(value="/index.html")
	public String index(Model model,HttpServletRequest request){
		List<SysUser> list = userMapper.list();
		model.addAttribute("userList", list);
		
		return "index";
	}
	
}
