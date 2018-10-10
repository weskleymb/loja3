package br.senac.rn.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.model.Marca;
import br.senac.rn.loja.model.Produto;
import br.senac.rn.loja.service.DepartamentoService;
import br.senac.rn.loja.service.MarcaService;
import br.senac.rn.loja.service.ProdutoService;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	@Autowired
	private MarcaService marcaService;
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping
	public String lista(Model model) {
		List<Produto> produtos = service.obterTodos();
		model.addAttribute("produtos", produtos);
		return "produto/lista";
	}
	
	@GetMapping("cadastrar")
	public String cadastrar(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		List<Marca> marcas = marcaService.obterTodos();
		model.addAttribute("marcas", marcas);
		List<Departamento> departamentos = departamentoService.buscarTodos();
		model.addAttribute("departamentos", departamentos);
		return "produto/form";
	}
	
	@PostMapping
	public String salvar(Produto produto) {
		service.salvar(produto);
		return "redirect:/produto";
	}

}
