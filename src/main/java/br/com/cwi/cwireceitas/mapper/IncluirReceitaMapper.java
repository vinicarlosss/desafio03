package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.controller.request.IncluirPostRequest;
import br.com.cwi.cwireceitas.domain.Ingrediente;
import br.com.cwi.cwireceitas.domain.Receita;

import java.math.BigDecimal;
import java.util.List;

public class IncluirReceitaMapper {
    public static Receita toEntity(IncluirPostRequest request, List<Ingrediente> ingredientes) {

        Receita entity = new Receita();
        entity.setTitulo(request.getTitulo());
        entity.setDescricao(request.getDescricao());
        entity.setTempo_preparo(request.getTempoPreparo());
        entity.setAvaliacao(new BigDecimal("0"));
        for(Ingrediente ingrediente:ingredientes){
            entity.adicionarIngrediente(ingrediente);
        }
        return entity;
    }
}
