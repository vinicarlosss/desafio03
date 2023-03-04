package br.com.cwi.cwireceitas.repository;

import br.com.cwi.cwireceitas.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
