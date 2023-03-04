package br.com.cwi.cwireceitas.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "ingredientes")
    private List<Receita> receitas = new ArrayList<>();
}
