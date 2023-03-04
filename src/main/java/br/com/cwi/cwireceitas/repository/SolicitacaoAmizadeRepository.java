package br.com.cwi.cwireceitas.repository;

import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoAmizadeRepository extends JpaRepository<SolicitacaoAmizade, Long> {




    Page<SolicitacaoAmizade> findAllByIdUsuarioSolicitado(Usuario usuario, Pageable pageable);

    boolean existsByIdUsuarioSolicitanteAndIdUsuarioSolicitado(Usuario idUsuarioSolicitante, Usuario idUsuarioSolicitado);

    List<SolicitacaoAmizade> findAllByIdUsuarioSolicitanteAndIdUsuarioSolicitado(Usuario usuarioSolicitante, Usuario usuarioSolicitado);

    SolicitacaoAmizade findByIdUsuarioSolicitanteAndIdUsuarioSolicitado(Usuario usuarioSolicitante, Usuario usuarioSolicitado);
}
