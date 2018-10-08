package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.repository.DepartamentoRepository;

@Service
@Transactional
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;
	
	public void salvar(Departamento departamento) {
		repository.save(departamento);
	}
	
	public Departamento buscarPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Departamento> buscarTodos() {
		return repository.findAll();
	}
	
}
