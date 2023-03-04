package br.com.cwi.cwireceitas.controller.response;

import br.com.cwi.cwireceitas.domain.Situacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListarSolicitacaoAmizadeRecebidaResponse {

    private Long id;
    private LocalDate dataSolicitacao;
    private Situacao situacao;
    private Long idUsuarioSolicitante;
    private String nomeUsuarioSolicitante;
    private String emailUsuarioSolicitante;
    private String imagemPerfilUrlUsuarioSolicitante;
    private String apelidoUsuarioSolicitante;
    private Long idUsuarioSolicitado;
    private String nomeUsuarioSolicitado;
    private String emailUsuarioSolicitado;
    private String imagemPerfilUrlUsuarioSolicitado;
    private String apelidoUsuarioSolicitado;

}
