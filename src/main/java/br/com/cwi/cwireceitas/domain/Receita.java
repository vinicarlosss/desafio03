package br.com.cwi.cwireceitas.domain;

import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Receita {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private Time tempo_preparo;
    private BigDecimal avaliacao;
    @ManyToMany
    @JoinTable(name = "receita_ingrediente",
                joinColumns = @JoinColumn(name = "id_receita"),
                inverseJoinColumns = @JoinColumn(name = "id_ingrediente"))
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public void adicionarIngrediente(Ingrediente ingrediente){
        this.getIngredientes().add(ingrediente);
        ingrediente.getReceitas().add(this);
    }
}
