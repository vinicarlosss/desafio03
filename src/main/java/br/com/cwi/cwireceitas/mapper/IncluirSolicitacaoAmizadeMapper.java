package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.controller.response.IncluirSolicitacaoAmizadeResponse;
import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;

public class IncluirSolicitacaoAmizadeMapper {
    public static IncluirSolicitacaoAmizadeResponse toResponse(SolicitacaoAmizade entity) {
        return IncluirSolicitacaoAmizadeResponse.builder()
                .id(entity.getId())
                .idUsuarioSolicitante(entity.getIdUsuarioSolicitante().getId())
                .nomeUsuarioSolicitante(entity.getIdUsuarioSolicitante().getNome())
                .imagemPerfilUrlUsuarioSolicitante(entity.getIdUsuarioSolicitante().getImagemPerfilUrl())
                .idUsuarioSolicitado(entity.getIdUsuarioSolicitado().getId())
                .nomeUsuarioSolicitado(entity.getIdUsuarioSolicitado().getNome())
                .imagemPerfilUrlUsuarioSolicitado(entity.getIdUsuarioSolicitado().getImagemPerfilUrl())
                .situacao(entity.getSituacao())
                .dataSolicitacao(entity.getDataSolicitacao())
                .build();
    }
}
