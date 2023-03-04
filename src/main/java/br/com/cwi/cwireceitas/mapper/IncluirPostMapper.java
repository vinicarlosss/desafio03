package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.controller.request.IncluirPostRequest;
import br.com.cwi.cwireceitas.controller.response.IncluirPostResponse;
import br.com.cwi.cwireceitas.domain.Post;
import br.com.cwi.cwireceitas.domain.Receita;
import br.com.cwi.cwireceitas.security.domain.Usuario;

import java.time.LocalDate;


public class IncluirPostMapper {

    public static Post toEntity(IncluirPostRequest request, Receita receita, Usuario usuario) {
        Post entity = new Post();
        entity.setDataPublicacao(LocalDate.now());
        entity.setIdReceita(receita);
        entity.setIdUsuario(usuario);
        entity.setPrivacidade(request.getPrivacidade());
        entity.setAtivo(true);


        return entity;
    }

    public static IncluirPostResponse toResponse(Post post) {
        return IncluirPostResponse.builder()
                .id(post.getId())
                .dataPublicacao(post.getDataPublicacao())
                .titulo(post.getIdReceita().getTitulo())
                .build();
    }
}
