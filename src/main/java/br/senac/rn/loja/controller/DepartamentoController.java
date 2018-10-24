package br.senac.rn.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.senac.rn.loja.model.Departamento;

@Controller
@RequestMapping("departamento")
public class DepartamentoController extends GenericController<Departamento> {

	@Override
	public Class<Departamento> getClassType(){
		return Departamento.class;
	}
	
//	@Autowired
//	private DepartamentoService service;
//	
//	@GetMapping
//	public String lista(Model model) {
//		model.addAttribute("departamentos", service.buscarTodos());
//		return "departamento/lista";
//	}
	
}
