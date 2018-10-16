package br.senac.rn.loja.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.senac.rn.loja.model.Marca;
import br.senac.rn.loja.repository.MarcaRepository;

@Service
@Transactional
public class MarcaService {

	@Autowired
	private MarcaRepository repository;
	
	public void salvar(Marca marca) {
		repository.save(marca);
	}
	
	public List<Marca> obterTodos() {
		return repository.findAll();
	}
	
	public Marca obterPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
	
}