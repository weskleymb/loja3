package br.senac.rn.loja.controller;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import br.senac.rn.loja.service.GenericService;

public abstract class GenericController<T> {

	protected final String URL_LISTAR = "lista";
	protected final String URL_CADASTRAR = "cadastrar";
	protected final String URL_EDITAR = "editar/{id}";
	
	@Autowired
	private GenericService<T> service;
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute(getNomeEntidadeLista(), service.obterTodos());
		System.out.println(service.obterTodos());
		return getPath() + URL_LISTAR;
	}
	
	@GetMapping(URL_CADASTRAR)
	public String cadastrar(Model model) {
		return null;
	}
	
	@GetMapping(URL_EDITAR)
	public String editar(Model model) {
		return null;
	}
	
	protected String getPath() {
		return getNomeEntidade();
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> inferirTipo() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected String getNomeEntidade() {
		return StringUtils.uncapitalize(inferirTipo().getSimpleName());
	}
	
	protected String getNomeEntidadeLista() {
		StringBuilder builder = new StringBuilder(getNomeEntidade());
		return builder.append("s").toString();
	}
	
}
