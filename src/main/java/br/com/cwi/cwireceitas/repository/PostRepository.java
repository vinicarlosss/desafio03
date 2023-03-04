package br.com.cwi.cwireceitas.repository;

import br.com.cwi.cwireceitas.domain.Post;
import br.com.cwi.cwireceitas.domain.Privacidade;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByIdUsuarioAndPrivacidade(Usuario usuario, Privacidade publico, Pageable pageable);

    Page<Post> findAllByIdUsuario(Usuario usuario, Pageable pageable);

}
