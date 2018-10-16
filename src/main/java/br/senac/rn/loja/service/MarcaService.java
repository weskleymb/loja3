package br.senac.rn.loja.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Marca;

@Service
@Transactional
<<<<<<< HEAD
public class MarcaService {

	@Autowired
	private MarcaRepository repository;
	
	public void salvar(Marca marca) {
		repository.save(marca);
	}
	
	public List<Marca> buscarTodos() {
		return repository.findAll();
	}
	
	public Marca obterPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public void remover(Integer id) {
		repository.deleteById(id);
	}
	
}
=======
public class MarcaService extends GenericService<Marca> {}
>>>>>>> 140f8d4281d9b7280dc0180297bd36716b4d78b6
