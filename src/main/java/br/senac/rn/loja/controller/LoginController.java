package br.senac.rn.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
<<<<<<< HEAD
	
	@GetMapping
	public String login (Model model) {
		return "login";
	}

=======

	@GetMapping
	public String login(Model model) {
		return "login";
	}
	
>>>>>>> 9acd27cf94485285974f67c642867d0a4eb452c3
}
