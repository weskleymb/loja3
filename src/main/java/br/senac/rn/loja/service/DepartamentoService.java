package br.senac.rn.loja.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Departamento;

@Service
@Transactional
public class DepartamentoService extends GenericService<Departamento> {

//	@Autowired
//	private DepartamentoRepository repository;
//	
//	public void salvar(Departamento departamento) {
//		repository.save(departamento);
//	}
//	
//	public Departamento buscarPorId(Integer id) {
//		return repository.findById(id).get();
//	}
//	
//	public void remover(Integer id) {
//		repository.deleteById(id);
//	}
//	
//	public List<Departamento> buscarTodos() {
//		return repository.findAll();
//	}
//	
}
