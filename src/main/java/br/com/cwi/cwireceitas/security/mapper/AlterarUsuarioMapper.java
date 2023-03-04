package br.com.cwi.cwireceitas.security.mapper;

import br.com.cwi.cwireceitas.security.controller.response.AlterarUsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;

public class AlterarUsuarioMapper {
    public static AlterarUsuarioResponse toResponse(Usuario usuario) {
        return AlterarUsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .apelido(usuario.getApelido())
                .imagemPerfilUrl(usuario.getImagemPerfilUrl())
                .build();
    }
}
