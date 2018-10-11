package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Produto;
import br.senac.rn.loja.repository.DepartamentoRepository;
import br.senac.rn.loja.repository.MarcaRepository;
import br.senac.rn.loja.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired 
	private MarcaRepository marcaRepository;
	
	public List<Produto> obterTodos() {
		return repository.findAll();
	}

	public void salvar(Produto produto) {
		departamentoRepository.save(produto.getDepartamento());
		marcaRepository.save(produto.getMarca());
		repository.save(produto);
	}
	
	public Produto buscarPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
}
