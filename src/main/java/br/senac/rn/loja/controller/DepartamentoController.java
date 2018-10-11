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

import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.service.DepartamentoService;

@Controller
@RequestMapping("departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;
	
	@GetMapping
	public String lista(Model model) {
		List<Departamento> departamentos = service.buscarTodos();
		model.addAttribute("departamentos", departamentos);
		return "departamento/lista";
	}
	
	@GetMapping("cadastrarDep")
	public String novo(Model model) {
		Departamento departamento = new Departamento();
		model.addAttribute(departamento);
		return "departamento/form";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Departamento departamento = service.buscarPorId(id);
		model.addAttribute(departamento);
		return "departamento/form";
	}
	
	@GetMapping("remover/{id}")
	public String remover(@PathVariable("id") Integer id, Model model) {
		service.remover(id);
		return "redirect:/departamento";
	}
	
	@PostMapping
	public ModelAndView salvar(Departamento departamento) {
		service.salvar(departamento);
		ModelAndView mav = new ModelAndView(new RedirectView("/departamento", true));
		return mav;
	}
}
