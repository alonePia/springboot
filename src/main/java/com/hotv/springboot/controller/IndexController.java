package com.hotv.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotv.springboot.core.QueryFilter;
import com.hotv.springboot.entity.User;
import com.hotv.springboot.mapper.UserMapper;

@Controller
public class IndexController {
	Logger logger = Logger.getLogger(IndexController.class);
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value="/index.html")
	public String index(Model model,HttpServletRequest request){
		List<User> list = userMapper.getList();
		model.addAttribute("userList", list);
		
		QueryFilter filter = new QueryFilter();
		filter.put("username", "096");
		User user = userMapper.getUserByUsername(filter);
		logger.debug("IndexController index getUserByUsername:"+user.getUserId()+","+user.getUsername()+","+user.getAddress());
		
		filter = new QueryFilter();
		filter.put("userId", user.getUserId());
		userMapper.delete(filter);
		
		user = new User();
		user.setUsername("alone");
		user.setAddress("北京市密云县");
		userMapper.insert(user);
		
		return "index";
	}
	
}
