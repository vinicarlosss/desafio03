package br.com.cwi.cwireceitas.factories;

import br.com.cwi.cwireceitas.domain.Receita;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;

public class ReceitaFactory {

    public static Receita get(){
        Receita receita = new Receita();
        receita.setId(SimpleFactory.getRandomLong());
        receita.setTitulo("Cocada");
        receita.setDescricao("Como fazer cocada");
        receita.setTempo_preparo(new Time(150));
        receita.setIngredientes(new ArrayList<>());
        receita.setAvaliacao(new BigDecimal("0"));

        return receita;
    }
}
