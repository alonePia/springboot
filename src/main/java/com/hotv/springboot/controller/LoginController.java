package com.hotv.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotv.springboot.core.QueryFilter;
import com.hotv.springboot.core.ResponseData;
import com.hotv.springboot.entity.SysUser;
import com.hotv.springboot.mapper.SysUserMapper;

/**
 * 用户登录
 * @author hotv
 * @since 2017-11-12
 */
@Controller
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@RequestMapping(value = "/login.html")
	public String index(Model model, HttpServletRequest request) {
		return "login";
	}
	
	@RequestMapping(value = "/register.html")
	public String register(Model model, HttpServletRequest request) {
		return "register";
	}
	
	@RequestMapping(value = "/login.json")
	@ResponseBody
	public ResponseData login(Model model, HttpServletRequest request) {
		ResponseData data = new ResponseData(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String encodePassword = new Md5Hash(password).toHex();
		logger.debug("MD5 password "+encodePassword);
		
		QueryFilter filter = new QueryFilter();
		filter.put("username", username);
		SysUser sysUser = sysUserMapper.getUserByUsername(filter);
		
		if(sysUser==null || sysUser.getUserId()==null){
			logger.debug("LoginController login 登录用户不存在");
			data.setSuccess(false);
			data.setMessage("登录用户不存在");
			return data;
		}else{
			if(sysUser.getPassword().equals(encodePassword)){
				logger.debug("LoginController login 登录成功");
				
				UsernamePasswordToken token = new UsernamePasswordToken(username,
						password);
				if (null!=request.getParameter("rememberMe") && !"".equals(request.getParameter("rememberMe"))){
					token.setRememberMe(true);
				}
				
				SecurityUtils.getSubject().login(token);
				SecurityUtils.getSubject().getSession().setAttribute("CURRENT_USER", sysUser);
				
				data.setSuccess(true);
				return data;
			}else{
				logger.debug("LoginController login 登录用户密码不正确");
				data.setSuccess(false);
				data.setMessage("登录密码不正确");
				return data;
			}
		}
	}

}
