package br.com.cwi.cwireceitas.security.domain;

import br.com.cwi.cwireceitas.domain.Amizade;
import br.com.cwi.cwireceitas.domain.Post;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    private String apelido;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    private String imagemPerfilUrl;
    @Column(nullable = false)
    private boolean ativo;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();
    @OneToMany(mappedBy = "idUsuario")
    private List<Post> posts = new ArrayList<>();
    @OneToMany
    @JoinTable(name = "amizade_usuario",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_amizade"))
    private List<Amizade> amizades = new ArrayList<>();


    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }
    public void adicionarAmizade(Amizade amizade){
        this.getAmizades().add(amizade);
        amizade.getIdUsuarioDois().getAmizades().add(amizade);
    }
}

