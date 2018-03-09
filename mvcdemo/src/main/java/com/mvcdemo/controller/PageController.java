package com.mvcdemo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.User;

@Controller
public class PageController 
{
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping("/")
	public String showHomePage()
	{
		return "index";
	}
	
	@RequestMapping("/login")
	public String showLogin(Model model,@RequestParam(name="error",required=false)String error)
	{
		model.addAttribute("user", new User());
		if(error!=null)
		{
		model.addAttribute("error","Login Failed");
		}
		return "Login-Register";
	}
	
	@RequestMapping("/aboutus")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/register")
	public String showRegister()
	{
		return "Register";
	}
}
