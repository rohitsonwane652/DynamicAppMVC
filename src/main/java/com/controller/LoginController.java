package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.LoginBean;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginservice;
	 
//	 public LoginController(LoginService loginservice ) {
//	        this.loginservice = loginservice;
//	    }
	 
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showForm(@ModelAttribute("loginbean") LoginBean loginbean, BindingResult result)
	{
		return "login";
	}
	
	@RequestMapping(value="/submitlogin", method=RequestMethod.POST)
	public String authenticate(@ModelAttribute("loginbean") LoginBean loginbean, BindingResult result)
	{
		if(loginservice.validate(loginbean))
			return "success";
		else
			return "invalid";
	}
}
