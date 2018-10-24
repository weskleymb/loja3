package br.senac.rn.loja.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Departamento departamento) {
		repository.save(departamento);
	}
	
	@PutMapping("/edita/{id}")
	public ResponseEntity<Departamento> editar(@PathVariable Integer id,
			@RequestBody Departamento departamento) {
		Departamento dep = repository.findById(id).get();
		dep.setNome(departamento.getNome());
		dep.setSigla(departamento.getSigla());
		dep.setFone(departamento.getFone());
		dep.setDesconto(departamento.getDesconto());
		repository.save(dep);
		return ResponseEntity.status(HttpStatus.OK).body(dep);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Departamento> remover(@PathVariable Integer id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}
