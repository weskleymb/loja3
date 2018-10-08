package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.service.DepartamentoService;

@Controller
@RequestMapping("departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	public String lista(Model model) {
		model.addAttribute("departamentos", service.buscarTodos());
		return "departamento/lista";
	}

}
