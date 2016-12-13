package it.unical.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.unical.login.model.Credentials;
import it.unical.login.persistence.UsersDAO;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsersDAO usersDAO;
	
	@RequestMapping
	public String loginAttempt(@ModelAttribute Credentials credentials) {
		
		if(usersDAO.checkCredentials(credentials)) {
			return "home";
		}
		return "login";
	}
}
