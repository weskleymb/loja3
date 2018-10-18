package br.senac.rn.loja.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Departamento;

@Service
@Transactional
<<<<<<< HEAD
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
=======
public class DepartamentoService extends GenericService<Departamento> {}
>>>>>>> ae0e087066c82e6fd3eed9026c18276d6efd1d22
