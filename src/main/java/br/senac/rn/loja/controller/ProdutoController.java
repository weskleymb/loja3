package br.senac.rn.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.model.Produto;
import br.senac.rn.loja.service.ProdutoService;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public String lista(Model model) {
		List<Produto> produtos = service.obterTodos();
		model.addAttribute("produtos", produtos);
		return "produto/lista";
	}
	
}
