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
	
	public List<Uf> obterTodos() {
		return repository.findAll();
	}

	public void salvar(Uf uf) {
		repository.save(uf);
	}
}
