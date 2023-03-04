package br.com.cwi.cwireceitas.repository;

import br.com.cwi.cwireceitas.domain.Amizade;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
    Page<Amizade> findAllByIdUsuarioDois(Usuario usuario, Pageable pageable);

    Page<Amizade> findAllByIdUsuarioUm(Usuario usuario, Pageable pageable);

    boolean existsByIdUsuarioUm(Usuario usuario);
}
