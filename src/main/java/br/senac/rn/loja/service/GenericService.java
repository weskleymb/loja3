package br.senac.rn.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.senac.rn.loja.repository.GenericRepository;

public abstract class GenericService<T> {

	@Autowired
	protected GenericRepository<T> repository;
	
	public void salvar(T entidade) {
		repository.save(entidade);
	}
	
	public List<T> obterTodos() {
		return repository.findAll();
	}
	
	public T obterPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(T entidade) {
		repository.delete(entidade);
	}
	
}
