package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.domain.Ingrediente;


public class IncluirIngredienteMapper {
    public static Ingrediente toEntity(String ingrediente) {
        Ingrediente entity = new Ingrediente();
        entity.setNome(ingrediente);
        return entity;
    }
}
