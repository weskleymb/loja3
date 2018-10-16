package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.model.Estado;
import br.senac.rn.loja.repository.DepartamentoRepository;
import br.senac.rn.loja.repository.EstadoRepository;

@Service
@Transactional
public class EstadoService {
	@Autowired
	private EstadoRepository repository;
	
	public void salvar(Estado estado) {
		repository.save(estado);
	}
	
	public Estado buscarPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Estado> buscarTodos() {
		return repository.findAll();
	}
}
