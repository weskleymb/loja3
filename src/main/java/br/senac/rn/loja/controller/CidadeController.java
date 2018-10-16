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

import br.senac.rn.loja.model.Cidade;
import br.senac.rn.loja.model.Marca;
import br.senac.rn.loja.service.CidadeService;
import br.senac.rn.loja.service.MarcaService;

@Controller
@RequestMapping("cidade")
public class CidadeController {

	@Autowired
	private CidadeService service;
	
	@GetMapping
	public String lista(Model model) {
		List<Cidade> cidades = service.obterTodos();
		model.addAttribute("cidades", cidades);
		return "cidade/lista";
	}
	
	@GetMapping("cadastrar")
	public String novo(Model model) {
		Cidade cidade = new Cidade();
		model.addAttribute(cidade);
		return "cidade/form";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Cidade cidade =service.obterPorId(id);
		model.addAttribute(cidade);
		return "cidade/form";
	}
	
	@GetMapping("remover/{id}")
	public String remover(@PathVariable("id") Integer id, Model model) {
		service.remover(id);
		return "redirect:/cidade";
	}
	
		
	@PostMapping
	public ModelAndView salvar(Cidade cidade) {
		service.salvar(cidade);
		ModelAndView mav = new ModelAndView(new RedirectView("/cidade", true));
		return mav;
	}
	
}
