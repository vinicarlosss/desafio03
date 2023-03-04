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
public class IncluirPostResponse {

    private Long id;
    private LocalDate dataPublicacao;
    private String titulo;
}
