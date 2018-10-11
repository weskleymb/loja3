package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.service.CidadeService;

@Controller
@RequestMapping("cidade")
public class CidadeController {
	@Autowired
	private CidadeService service;
	
	@GetMapping
	public String lista(Model model) {
		model.addAttribute("cidades", service.obterTodos());
		return "cidade/lista";
	}
}
