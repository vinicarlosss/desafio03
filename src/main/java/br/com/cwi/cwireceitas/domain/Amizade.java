package br.com.cwi.cwireceitas.domain;

import br.com.cwi.cwireceitas.security.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Amizade {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDate dataInicio;
    @ManyToOne
    @JoinColumn(name = "id_usuario_um")
    private Usuario idUsuarioUm;
    @ManyToOne
    @JoinColumn(name = "id_usuario_dois")
    private Usuario idUsuarioDois;
    @OneToMany(mappedBy = "amizades")
    private List<Amizade> amizades;
}
