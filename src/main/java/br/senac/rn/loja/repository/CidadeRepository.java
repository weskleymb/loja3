package br.senac.rn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.rn.loja.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
