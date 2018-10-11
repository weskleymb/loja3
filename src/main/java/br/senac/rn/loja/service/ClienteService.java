package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Cliente;
import br.senac.rn.loja.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public void salvar(Cliente cliente) {
		repository.save(cliente);
	}
	
	public Cliente bucarPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}

	public List<Cliente> buscarTodos() {
		return repository.findAll();
	}
}
