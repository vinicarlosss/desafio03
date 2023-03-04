package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.controller.response.ListarSolicitacaoAmizadeRecebidaResponse;
import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;

public class ListarSolicitacaoAmizadeRecebidaMapper {
    public static ListarSolicitacaoAmizadeRecebidaResponse toResponse(SolicitacaoAmizade entity) {
        return ListarSolicitacaoAmizadeRecebidaResponse.builder()
                .id(entity.getId())
                .dataSolicitacao(entity.getDataSolicitacao())
                .situacao(entity.getSituacao())
                .idUsuarioSolicitante(entity.getIdUsuarioSolicitante().getId())
                .nomeUsuarioSolicitante(entity.getIdUsuarioSolicitante().getNome())
                .emailUsuarioSolicitante(entity.getIdUsuarioSolicitante().getEmail())
                .imagemPerfilUrlUsuarioSolicitante(entity.getIdUsuarioSolicitante().getImagemPerfilUrl())
                .apelidoUsuarioSolicitante(entity.getIdUsuarioSolicitante().getApelido())
                .idUsuarioSolicitado(entity.getIdUsuarioSolicitado().getId())
                .nomeUsuarioSolicitado(entity.getIdUsuarioSolicitado().getNome())
                .emailUsuarioSolicitado(entity.getIdUsuarioSolicitado().getEmail())
                .imagemPerfilUrlUsuarioSolicitado(entity.getIdUsuarioSolicitado().getImagemPerfilUrl())
                .apelidoUsuarioSolicitado(entity.getIdUsuarioSolicitado().getApelido())
                .build();
    }
}
