package br.senac.rn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.senac.rn.loja.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {}
