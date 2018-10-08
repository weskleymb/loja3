package br.senac.rn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.rn.loja.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
