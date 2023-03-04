package br.com.cwi.cwireceitas.controller.request;

import lombok.Data;

@Data
public class IncluirSolicitacaoAmizadeRequest {

    private Long idUsuarioSolicitado;
    private Long idUsuarioSolicitante;
}
