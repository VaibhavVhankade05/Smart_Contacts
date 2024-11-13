package com.smart.contact.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.contact.entity.User;
import com.smart.contact.helper.Message;
import com.smart.contact.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController 
{
	
	@Autowired 
	private UserRepository userRepository;

	@RequestMapping("/")
	public String home(Model model)
	{

		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}


	@RequestMapping("/about")
	public String about(Model model)
	{

		model.addAttribute("title","About - Smart Contact Manager");
		return "about";
	}


	@RequestMapping("/login")
	public String login(Model model)
	{

		model.addAttribute("title","Login - Smart Contact Manager");
		return "login";
	}

	@RequestMapping("/signup")
	public String signup(Model model)
	{

		model.addAttribute("title","Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}


	@RequestMapping(value="/register" , method= RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1, @RequestParam(value="agreement", defaultValue="false") boolean agreement, Model model,HttpSession session)
	{
		try 
		{
			if(!agreement)
			{
				System.out.println("Please Accept The Trems & Condition");
				throw new Exception("Invalid");
			}
			
			if(result1.hasErrors())
			{
				System.out.println("Error" + result1.toString());
				model.addAttribute("user",user);
				return "signup";
			}

			user.setRole("User");
			user.setEnabled(true);
			System.out.println("Agreement"+agreement);
			System.out.println("USER"+user);
			
			User result = userRepository.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered !" ,"alert-success"));
			return "signup";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went Wrong !!!" + e.getMessage(),"alert-danger"));
			return "signup";
		}

	}
}

