package br.com.cwi.cwireceitas.service.search;

import br.com.cwi.cwireceitas.domain.Ingrediente;
import br.com.cwi.cwireceitas.repository.IngredienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarIngredienteService {
    @Autowired
    private IngredienteRespository ingredienteRespository;

    public Ingrediente existByNome(String nome) {
        return ingredienteRespository.findByNome(nome);
    }
}
