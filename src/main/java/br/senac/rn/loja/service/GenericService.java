package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.repository.GenericRepository;

@Service
@Transactional
public abstract class GenericService<T> {

	@Autowired
	private GenericRepository<T> repository;
	
	public void salvar(T obj) {
		repository.save(obj);
	}
	
	public List<T> obterTodos() {
		return repository.findAll();
	}
	
	public T obterPorId(Integer id) {
		return repository.findById(id).get();
	}
	
}
