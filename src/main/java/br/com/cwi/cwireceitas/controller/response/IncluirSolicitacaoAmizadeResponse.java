package br.com.cwi.cwireceitas.controller.response;

import br.com.cwi.cwireceitas.domain.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncluirSolicitacaoAmizadeResponse {

    private Long id;
    private Long idUsuarioSolicitante;
    private String nomeUsuarioSolicitante;
    private String imagemPerfilUrlUsuarioSolicitante;
    private Long idUsuarioSolicitado;
    private String nomeUsuarioSolicitado;
    private String imagemPerfilUrlUsuarioSolicitado;
    private LocalDate dataSolicitacao;
    private Situacao situacao;


}
