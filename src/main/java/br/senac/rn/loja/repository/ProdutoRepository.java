package br.senac.rn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.rn.loja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
