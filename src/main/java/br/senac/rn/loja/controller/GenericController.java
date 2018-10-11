package br.senac.rn.loja.controller;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.service.GenericService;

@Controller
public abstract class GenericController<T> {

	protected final String URL_LISTAR = "/lista";
	protected final String URL_CADASTRAR = "/cadastrar";
	protected final String URL_EDITAR = "/editar/{id}";
	private final String SUFIXO_LISTA = "Lista";
	private final String SUFIXO_CONTROLLER = "Controller";
	
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
		return inferirNomeControlador();
	}
	
	protected Class<T> inferirTipo() {
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
		return clazz;
	}
	
	protected String getNomeEntidade() {
		return StringUtils.uncapitalize(inferirTipo().getSimpleName());
	}
	
	protected String getNomeEntidadeLista() {
//		StringBuilder builder = new StringBuilder(getNomeEntidade());
//		return builder.append(SUFIXO_LISTA).toString();
		return getNomeEntidade() + "s";
	}
	
	private String inferirNomeControlador() {
		String nomeControlador = getClass().getSimpleName();
		return StringUtils.uncapitalize(nomeControlador.replace(SUFIXO_CONTROLLER, ""));
	}
	
	private String inferirMapeamento() {
		return getClass().getAnnotation(RequestMapping.class).value()[0];
	}
	
}
