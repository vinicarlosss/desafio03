package br.com.cwi.cwireceitas.security.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AlterarUsuarioRequest {

    @NotBlank
    private String nome;
    private String apelido;
    private String imagemPerfilUrl;
}
