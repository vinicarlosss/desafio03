package br.com.cwi.cwireceitas.validator;

import br.com.cwi.cwireceitas.controller.request.IncluirPostRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class IncluirPostValidator {
    private static final int TAMANHO_MINIMO = 4;
    public void validar(IncluirPostRequest request) {

        if(isNull(request)){
            throw new ResponseStatusException(BAD_REQUEST, "Dados não informados");
        }

        if(request.getTitulo().trim().length() < TAMANHO_MINIMO){
            throw new ResponseStatusException(BAD_REQUEST, "Título deve ter no mínimo 4 caracteres");
        }
        if(request.getDescricao().trim().length() < TAMANHO_MINIMO){
            throw new ResponseStatusException(BAD_REQUEST, "Descrição deve ter no mínimo 4 caracteres");
        }
        if(isNull(request.getTempoPreparo())){
            throw new ResponseStatusException(BAD_REQUEST, "Tempo de preparo é obrigatório");
        }
        if(isNull(request.getIngredientes())){
            throw new ResponseStatusException(BAD_REQUEST, "Ingredientes são obrigatórios");
        }
    }
}
