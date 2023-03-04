package br.com.cwi.cwireceitas.repository;

import br.com.cwi.cwireceitas.domain.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRespository extends JpaRepository<Ingrediente, Long> {
    Ingrediente findByNome(String nome);
}
