package br.com.cwi.cwireceitas.controller.request;

import br.com.cwi.cwireceitas.domain.Privacidade;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Data
public class IncluirPostRequest {

    @NotNull
    @Enumerated(STRING)
    private Privacidade privacidade;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    private Time tempoPreparo;
    @NotNull
    private List<String> ingredientes;
}
