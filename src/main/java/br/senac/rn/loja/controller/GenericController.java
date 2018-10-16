package br.senac.rn.loja.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.senac.rn.loja.service.GenericService;

public abstract class GenericController<T> {

	protected final String PAGINA_LISTA = "lista";
	protected final String PAGINA_CADASTRAR = "form";
	
	protected final String URL_CADASTRAR = "cadastrar";
	protected final String URL_EDITAR = "editar/{id}";
	
	protected final String SUFIXO_LISTA = "Lista";
	
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
		if (!model.containsAttribute(getNomeEntidade())) {
			try {
				System.out.println(getClassType().getDeclaredConstructor().newInstance());
				model.addAttribute(getClassType().getDeclaredConstructor().newInstance());
			} catch (Exception exception) {}
		}
		return getPath() + PAGINA_CADASTRAR;
	}
	
	@GetMapping(URL_EDITAR)
	public String editar(@PathVariable Integer id, Model model) {
		model.addAttribute(service.obterPorId(id));
		return getPath() + PAGINA_CADASTRAR;
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
		return builder.append(SUFIXO_LISTA).toString();
	}
	
//	private Class<T> getTipoGenerico() {
//	@SuppressWarnings("unchecked")
//	Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//	return clazz;
//}
	
}
