package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.controller.response.ListarPostsUsuarioResponse;
import br.com.cwi.cwireceitas.domain.Comentario;
import br.com.cwi.cwireceitas.domain.Ingrediente;
import br.com.cwi.cwireceitas.domain.Post;

import java.util.ArrayList;

public class ListarPostsUsuarioMapper {

    public static ListarPostsUsuarioResponse toResponse(Post entity) {
        ListarPostsUsuarioResponse response = new ListarPostsUsuarioResponse();
        response.setId(entity.getId());
        response.setTitulo(entity.getIdReceita().getTitulo());
        response.setDescricao(entity.getIdReceita().getDescricao());
        response.setTempo_preparo(entity.getIdReceita().getTempo_preparo());
        response.setAvaliacao(entity.getIdReceita().getAvaliacao());
        response.setIngredientes(new ArrayList<>());
        response.setDataPublicacao(entity.getDataPublicacao());
        response.setNomeDonoPost(entity.getIdUsuario().getNome());
        response.setNomeComentario(new ArrayList<>());
        response.setTextoComentario(new ArrayList<>());
        response.setNumeroCurtidas(entity.getCurtidas().size());

        for(Ingrediente ingrediente: entity.getIdReceita().getIngredientes()){
            response.getIngredientes().add(ingrediente.getNome());
        }

        for(Comentario comentario: entity.getComentarios()){
            response.getNomeComentario().add(comentario.getIdUsuarioRemetente().getNome());
        }

        for(Comentario comentario: entity.getComentarios()){
            response.getTextoComentario().add(comentario.getTexto());
        }

        return response;
    }

}
