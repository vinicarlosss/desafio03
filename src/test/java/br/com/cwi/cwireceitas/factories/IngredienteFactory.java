package br.com.cwi.cwireceitas.factories;

import br.com.cwi.cwireceitas.domain.Ingrediente;

public class IngredienteFactory {

    public static Ingrediente get(){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(SimpleFactory.getRandomLong());
        ingrediente.setNome("Cebola");
        return ingrediente;
    }
}
