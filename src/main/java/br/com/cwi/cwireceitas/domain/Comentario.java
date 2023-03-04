package br.com.cwi.cwireceitas.domain;

import br.com.cwi.cwireceitas.security.domain.Usuario;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String texto;
    @ManyToOne
    @JoinColumn(name = "id_usuario_remetente")
    private Usuario idUsuarioRemetente;
    @ManyToOne
    @JoinColumn(name = "id_usuario_destinatario")
    private Usuario idUsuarioDestinatario;
    private boolean ativo;
    @ManyToOne
    @JoinTable(name = "post_comentario",
            joinColumns = @JoinColumn(name = "id_comentario"),
            inverseJoinColumns = @JoinColumn(name = "id_post"))
    private Post idPost;
}
