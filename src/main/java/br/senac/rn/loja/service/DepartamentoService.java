package br.senac.rn.loja.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.repository.DepartamentoRepository;

@Service
@Transactional
public class DepartamentoService extends GenericService<Departamento> {}
