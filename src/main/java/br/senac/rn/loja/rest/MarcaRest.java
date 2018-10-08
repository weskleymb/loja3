package br.senac.rn.loja.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.rn.loja.model.Marca;
import br.senac.rn.loja.service.MarcaService;

@RestController
@RequestMapping("marca")
public class MarcaRest {

	@Autowired
	private MarcaService service;
	
	@GetMapping("obter")
	public List<Marca> buscar() {
		return service.obterTodos();
	}
	
}
