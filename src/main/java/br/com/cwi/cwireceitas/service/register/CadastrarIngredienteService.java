package br.com.cwi.cwireceitas.service.register;

import br.com.cwi.cwireceitas.domain.Ingrediente;
import br.com.cwi.cwireceitas.repository.IngredienteRespository;
import br.com.cwi.cwireceitas.service.search.BuscarIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CadastrarIngredienteService {
    @Autowired
    private IngredienteRespository ingredienteRespository;

    @Autowired
    private BuscarIngredienteService buscarIngredienteService;


    public List<Ingrediente> cadastrar(List<Ingrediente> ingredientes) {
        List<Ingrediente> ingredientesReceita = new ArrayList<>();
        for(Ingrediente ingrediente:ingredientes){
            Ingrediente ingredienteJaCadastrado = buscarIngredienteService.existByNome(ingrediente.getNome());
            if(isNull(ingredienteJaCadastrado)) {
                ingredientesReceita.add(ingrediente);
                ingredienteRespository.save(ingrediente);
            }else{
                ingredientesReceita.add(ingredienteJaCadastrado);
            }
        }
        return  ingredientesReceita;
    }
}
