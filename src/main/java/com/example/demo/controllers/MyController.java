package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserDao;

@Controller
public class MyController 
{
@Autowired
private UserDao dao;

@GetMapping(value = "/")
public String registerUi()
{
	return "register";
	
}

@PostMapping(value = "/register")
 public String register(@ModelAttribute User user,Model model) 
 {
	String msg=dao.register(user);
	if(msg.equals("Registration Successfull"))
	{
		model.addAttribute("msg1", msg);
		System.out.println("my if block");
		return "login";
	}
	else
	{
		model.addAttribute("msg1", msg);
		System.out.println("my else block");
		return "register";
	}
	 
 }

@PostMapping(value = "/login")
public String login(@ModelAttribute User user,Model model)
{
	String msg=dao.login(user);
	if(msg.equals("Login Successfull"))
	{
		model.addAttribute("msg1", msg);
		return "home";
	}
	else
	{
		model.addAttribute("msg1", msg);
		return "login";
	}
	
}

@GetMapping(value = "/show")
public String show(@ModelAttribute User user,Model model)
{  
	List<User> list=dao.show();
	System.out.println(list);
	model.addAttribute("list1", list);
	return "show";
	
}
}
