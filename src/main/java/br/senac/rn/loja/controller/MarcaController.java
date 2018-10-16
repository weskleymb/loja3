package br.senac.rn.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.senac.rn.loja.model.Marca;
import br.senac.rn.loja.service.MarcaService;

@Controller
@RequestMapping("marca")
public class MarcaController extends GenericController<Marca> {

	@Autowired
	private MarcaService service;
	
	@GetMapping
	public String lista(Model model) {
		List<Marca> marcas = service.buscarTodos();
		model.addAttribute("marcas", marcas);
		return "marca/lista";
	}
	
	@GetMapping("cadastrar")
	public String novo(Model model) {
		Marca marca = new Marca();
		model.addAttribute(marca);
		return "marca/form";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Marca marca = service.obterPorId(id);
		model.addAttribute(marca);
		return "marca/form";
	}
	
	@GetMapping("remover/{id}")
	public String remover(@PathVariable("id") Integer id, Model model) {
		service.remover(id);
		return "redirect:/marca";
	}
	
	@PostMapping
	public ModelAndView salvar(Marca marca) {
		service.salvar(marca);
		ModelAndView mav = new ModelAndView(new RedirectView("/marca", true));
		return mav;
	}	
	@Override
	public Class<Marca> getClassType() {
		return Marca.class;
	}
	
}
