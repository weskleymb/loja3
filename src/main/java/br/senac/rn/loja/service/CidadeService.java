package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Cidade;
import br.senac.rn.loja.repository.CidadeRepository;

@Service
@Transactional
public class CidadeService {
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> obterTodos() {
		return repository.findAll();
	}

	public void salvar(Cidade cidade) {
		repository.save(cidade);
	}

}
