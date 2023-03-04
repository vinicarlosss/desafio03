package br.com.cwi.cwireceitas.domain;

import br.com.cwi.cwireceitas.security.domain.Usuario;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class SolicitacaoAmizade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usuario_solicitado")
    private Usuario idUsuarioSolicitado;
    private LocalDate dataSolicitacao;
    @Enumerated(STRING)
    private Situacao situacao;
    @ManyToOne
    @JoinColumn(name = "id_usuario_solicitante")
    private Usuario idUsuarioSolicitante;

}
