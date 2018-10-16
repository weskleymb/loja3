package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.UF;
import br.senac.rn.loja.repository.UFRepository;

@Service
@Transactional
public class UFService {
	
	@Autowired
	private UFRepository repository;
	
	public void salvar (UF uf) {
		repository.save(uf);
	}
	
	public UF buscarPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
	
	public List<UF> buscarTodos() {
		return repository.findAll();
	}
	

}
