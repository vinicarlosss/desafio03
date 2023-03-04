package br.com.cwi.cwireceitas.security.controller.response;

import br.com.cwi.cwireceitas.domain.Amizade;
import br.com.cwi.cwireceitas.domain.Post;
import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalharUsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private String imagemPerfilUrl;
}
