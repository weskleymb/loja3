package br.senac.rn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.rn.loja.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {

}
