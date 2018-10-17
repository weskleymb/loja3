package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.senac.rn.loja.service.GenericService;

public abstract class GenericController<T> {

	protected final String PAGINA_LISTA = "lista";
	protected final String PAGINA_CADASTRAR = "form";
	
	protected final String URL_CADASTRAR = "cadastrar";
	protected final String URL_EDITAR = "editar/{id}";
	
	protected final String SUFIXO_LISTA= "Lista";
	
	@Autowired
	private GenericService<T> service;
	
	public abstract Class<T> getClassType();

	@GetMapping
	public String listar(Model model) {
		model.addAttribute(getNomeEntidadeLista(), service.obterTodos());
		return getPath() + PAGINA_LISTA;
	}
	
	@GetMapping(URL_CADASTRAR)
	public String cadastrar(Model model) {
		try {
			model.addAttibuto(getClassType(), getClassType())
			.getDeclaredConstrutor().newInstance());
			
		return getPath() + PAGINA_CADASTRAR;
	}
	
	@GetMapping(URL_EDITAR)
	public String editar(Model model) {
		return null;
	}
	
	@PostMapping
	public String salvar (T entidade) {
		service.salvar(entidade);
		return "redirect:" + getPath();
	}
	
	protected String getPath() {
		StringBuilder builder = new StringBuilder(getNomeEntidade());
		return builder.append("/").toString();
	}
	
	private String getNomeEntidade() {
		return StringUtils.uncapitalize(getClassType().getSimpleName());
	}
	
	private String getNomeEntidadeLista() {
		StringBuilder builder = new StringBuilder(getNomeEntidade());
		return builder.append("s").toString();
	}
	
}
