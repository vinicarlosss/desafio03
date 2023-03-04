package br.com.cwi.cwireceitas.security.mapper;

import br.com.cwi.cwireceitas.security.controller.request.UsuarioRequest;
import br.com.cwi.cwireceitas.security.controller.response.UsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        entity.setApelido(request.getApelido());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setImagemPerfilUrl(request.getImagemPerfilUrl());
        entity.setAtivo(true);
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .apelido(usuario.getApelido())
                .email(usuario.getEmail())
                .build();
    }
}
