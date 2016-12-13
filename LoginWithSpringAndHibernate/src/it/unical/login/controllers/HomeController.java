package it.unical.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.unical.login.model.Credentials;

@Controller
@RequestMapping("/")
public class HomeController {
	
	
	 @RequestMapping
	 public String homePage() {
		 return "home";
	 }
	 
	 @RequestMapping("/goToLogin")
	 public String goToLogin(Model model) {
		 model.addAttribute("credentials", new Credentials());
		 return "login";
	 }
	 

}
