package br.com.cwi.cwireceitas.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Data
public class ListarPostsUsuarioResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private Time tempo_preparo;
    private BigDecimal avaliacao;
    private List<String> ingredientes;
    private LocalDate dataPublicacao;
    private String nomeDonoPost;
    private List<String> nomeComentario;
    private List<String> textoComentario;
    private int numeroCurtidas;
}
