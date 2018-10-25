package br.senac.rn.loja.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	public ResponseEntity<?> obter(@PathVariable Integer id) {
		return Optional
				.ofNullable(repository.findById(id))
				.map(departamento -> new ResponseEntity<>(departamento, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Departamento> salvar(@RequestBody Departamento departamento) {
		return ResponseEntity.ok(repository.save(departamento));
	}
	
	@PutMapping("/edita/{id}")
	public ResponseEntity<Departamento> editar(@PathVariable Integer id, @RequestBody Departamento departamento) {
		Departamento departamentoEdita = repository.findById(id).get();
		BeanUtils.copyProperties(departamento, departamentoEdita, "id");
		repository.save(departamentoEdita);
		return ResponseEntity.ok(departamentoEdita);
	}
	
	@DeleteMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}
