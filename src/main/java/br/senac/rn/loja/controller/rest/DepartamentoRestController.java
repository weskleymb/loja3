package br.senac.rn.loja.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.repository.DepartamentoRepository;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoRestController {

	@Autowired
	private DepartamentoRepository repository;
	
	@GetMapping("/todos")
	public List<Departamento> listaTodos() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Departamento obter(@PathVariable Integer id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody Departamento departamento) {
		repository.save(departamento);
	}
	
}
