package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.cwireceitas.domain.Amizade;

public class SolicitacaoAmizadeMapper {
    public static SolicitacaoAmizadeResponse toResponse(Amizade amizade) {
        return SolicitacaoAmizadeResponse.builder()
                .dataInicio(amizade.getDataInicio())
                .id(amizade.getId())
                .build();
    }
}
