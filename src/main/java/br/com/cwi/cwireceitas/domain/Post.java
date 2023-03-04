package br.com.cwi.cwireceitas.domain;

import br.com.cwi.cwireceitas.security.domain.Usuario;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDate dataPublicacao;
    @OneToOne
    @JoinColumn(name = "id_receita")
    private Receita idReceita;
    @ManyToOne
    @JoinTable(name = "post_usuario",
            joinColumns = @JoinColumn(name = "id_post"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private Usuario idUsuario;
    @Enumerated(STRING)
    private Privacidade privacidade;
    private boolean ativo;
    @OneToMany(mappedBy = "idPost")
    private List<Comentario> comentarios = new ArrayList<>();
    @OneToMany(mappedBy = "idPost")
    private List<Curtir> curtidas = new ArrayList<>();
}
