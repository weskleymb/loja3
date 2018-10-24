package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.service.UfService;

@Controller
@RequestMapping("uf")
public class UfController {
	@Autowired
	private UfService service;
	
	@GetMapping
	public String lista(Model model) {
		model.addAttribute("ufs", service.obterTodos());
		return "uf/lista";
	}
}
