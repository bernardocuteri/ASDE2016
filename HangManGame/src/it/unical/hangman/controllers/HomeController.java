package it.unical.hangman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import it.unical.hangman.businessLogic.HangmanGame;

@Controller
@SessionAttributes("hangmanGame")
public class HomeController {
	
	@Autowired
	private WebApplicationContext context;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("hangmanGame", context.getBean("hangmanGame", HangmanGame.class));
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, params = "buy")
	public String buyCharacter(@ModelAttribute("hangmanGame") HangmanGame hm, @RequestParam String buy) {
		hm.buyLetter(buy);
		return "home";
	}

}
