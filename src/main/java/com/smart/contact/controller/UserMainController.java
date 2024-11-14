package com.smart.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserMainController 
{
	@RequestMapping("/index")
	public String dashBorad( Model model)
	{
		model.addAttribute("title", "DashBoard");
		return "normal/user_dashboard";
	}
}
