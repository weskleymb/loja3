package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import br.senac.rn.loja.service.GenericService;

public abstract class GenericController<T> {

	protected final String PAGINA_LISTA = "lista";
	protected final String PAGINA_CADASTRAR = "form";
	
	protected final String URL_CADASTRAR = "cadastrar";
	protected final String URL_EDITAR = "editar/{id}";
	
	
	@Autowired
	private GenericService<T> service;
	
	public abstract Class<T> getClassType();

	@GetMapping
	public String listar(Model model) {
		model.addAttribute(getNomeEntidadeLista(), service.obterTodos());
		return getPath() + PAGINA_CADASTRAR;
	}
	
	@GetMapping(URL_CADASTRAR)
	public String cadastrar(Model model) {
		return null;
	}
	
	@GetMapping(URL_EDITAR)
	public String editar(Model model) {
		return null;
	}
	
	private String getNomeEntidade() {
		return StringUtils.uncapitalize(getClassType().getSimpleName());
	}
	
	protected String getPath() {
		StringBuilder builder = new StringBuilder(getNomeEntidade());
		return builder.append("/").toString();
	}
	
	
	private String getNomeEntidadeLista() {
		StringBuilder builder = new StringBuilder(getNomeEntidade());
		return builder.append("s").toString();
	}
	
}
