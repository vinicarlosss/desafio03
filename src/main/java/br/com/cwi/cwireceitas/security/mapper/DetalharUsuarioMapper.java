package br.com.cwi.cwireceitas.security.mapper;

import br.com.cwi.cwireceitas.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;

public class DetalharUsuarioMapper {

    public static DetalharUsuarioResponse toResponse(Usuario usuario) {
        return DetalharUsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .imagemPerfilUrl(usuario.getImagemPerfilUrl())
                .build();
    }
}
