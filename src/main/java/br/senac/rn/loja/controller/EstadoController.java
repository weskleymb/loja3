package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.service.DepartamentoService;
import br.senac.rn.loja.service.EstadoService;

@Controller
@RequestMapping("estado")
public class EstadoController {

	@Autowired
	private EstadoService service;
	
	@GetMapping
	public String lista(Model model) {
		model.addAttribute("estados", service.buscarTodos());
		return "estado/lista";
	}
}
