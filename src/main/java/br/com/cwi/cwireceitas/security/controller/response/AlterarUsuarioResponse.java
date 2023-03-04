package br.com.cwi.cwireceitas.security.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlterarUsuarioResponse {

    private Long id;
    private String nome;
    private String apelido;
    private String imagemPerfilUrl;
}
