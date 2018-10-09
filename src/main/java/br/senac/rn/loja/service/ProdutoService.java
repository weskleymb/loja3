package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Produto;
import br.senac.rn.loja.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> obterTodos() {
		return repository.findAll();
	}

	public void salvar(Produto produto) {
		repository.save(produto);
	}
	
}
