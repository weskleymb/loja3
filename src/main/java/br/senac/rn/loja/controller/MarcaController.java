package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.model.Marca;
import br.senac.rn.loja.service.MarcaService;

@Controller
@RequestMapping("marca")
public class MarcaController extends GenericController<Marca> {

	@Autowired
	private MarcaService service;
	
	
	@GetMapping("remover/{id}")
	public String remover(@PathVariable("id") Integer id, Model model) {
		service.remover(id);
		return "redirect:/marca";
	}
		
	@Override
	public Class<Marca> getClassType() {
		return Marca.class;
	}
	
}
