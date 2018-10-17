package br.senac.rn.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.service.DepartamentoService;

@Controller
@RequestMapping("departamento")
public class DepartamentoController extends GenericController<Departamento> {

	@Override
	public Class<Departamento> getClassType() {
		return Departamento.class;
	}

}
