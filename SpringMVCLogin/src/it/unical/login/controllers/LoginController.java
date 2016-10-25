package it.unical.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("GET");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginRequest(@RequestParam String username, @RequestParam String password, Model model) {
		System.out.println(username +" " + password);
		
		return "home";
	}
	
}
