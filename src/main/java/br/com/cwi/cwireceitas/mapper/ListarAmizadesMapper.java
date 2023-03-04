package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.controller.response.ListarAmizadesResponse;
import br.com.cwi.cwireceitas.domain.Amizade;

public class ListarAmizadesMapper {

    public static ListarAmizadesResponse toResponse(Amizade entity){
        return ListarAmizadesResponse.builder()
                .id(entity.getId())
                .dataInicio(entity.getDataInicio())
                .idUsuarioUm(entity.getIdUsuarioUm().getId())
                .nomeUsuarioUm(entity.getIdUsuarioUm().getNome())
                .apelidoUsuarioUm(entity.getIdUsuarioUm().getApelido())
                .imagemPerfilUrlUsuarioum(entity.getIdUsuarioUm().getImagemPerfilUrl())
                .idUsuarioDois(entity.getIdUsuarioDois().getId())
                .nomeUsuarioDois(entity.getIdUsuarioDois().getNome())
                .apelidoUsuarioDois(entity.getIdUsuarioDois().getApelido())
                .imagemPerfilUrlUsuarioDois(entity.getIdUsuarioDois().getImagemPerfilUrl())
                .build();
    }
}
