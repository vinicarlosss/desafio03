package br.com.cwi.cwireceitas.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListarAmizadesResponse {

    private Long id;
    private LocalDate dataInicio;
    private Long idUsuarioUm;
    private String nomeUsuarioUm;
    private String apelidoUsuarioUm;
    private String imagemPerfilUrlUsuarioum;
    private Long idUsuarioDois;
    private String nomeUsuarioDois;
    private String apelidoUsuarioDois;
    private String imagemPerfilUrlUsuarioDois;
}
