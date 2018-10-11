package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Uf;
import br.senac.rn.loja.repository.UfRepository;

@Service
@Transactional
public class UfService {

	@Autowired
	private UfRepository repository;
	
	public void salvar(Uf uf) {
		repository.save(uf);
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Uf> buscarTodos() {
		return repository.findAll();
	}
	
	public Uf buscarPorId(Integer id) {
		return repository.findById(id).get();		
	}
}
