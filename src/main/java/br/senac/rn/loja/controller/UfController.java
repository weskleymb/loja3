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

import br.senac.rn.loja.model.Uf;
import br.senac.rn.loja.service.UfService;

@Controller
@RequestMapping("uf")
public class UfController {
	
	@Autowired
	private UfService service;
	
	@GetMapping
	public String lista(Model model) {
		List<Uf> ufs = service.buscarTodos();
		model.addAttribute(ufs);
		return "uf/lista";
	}
	
	@GetMapping("cadastrar")
	public String cadastrar(Model model) {
		Uf uf = new Uf();
		model.addAttribute(uf);
		return "uf/form";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Uf uf = service.buscarPorId(id);
		model.addAttribute(uf);
		return "uf/form";
	}
	
	@GetMapping("remover/{id}")
	public String remover(@PathVariable("id") Integer id, Model model) {
		service.remover(id);
		return "redirect:/uf";
	}
	
	@PostMapping
	public ModelAndView salvar(Uf uf) {
		service.salvar(uf);
		ModelAndView mav = new ModelAndView(new RedirectView("/uf", true));
		return mav;
	}
}
