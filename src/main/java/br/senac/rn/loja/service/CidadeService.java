package br.senac.rn.loja.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Cidade;
import br.senac.rn.loja.model.Marca;
import br.senac.rn.loja.repository.CidadeRepository;
import br.senac.rn.loja.repository.MarcaRepository;

@Service
@Transactional
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public void salvar(Cidade cidade) {
		repository.save(cidade);
	}
	
	public List<Cidade> obterTodos() {
		return repository.findAll();
	}
	
	public Cidade obterPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
	
}