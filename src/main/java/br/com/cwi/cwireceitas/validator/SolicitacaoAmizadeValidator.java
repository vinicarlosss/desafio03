package br.com.cwi.cwireceitas.validator;

import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static br.com.cwi.cwireceitas.domain.Situacao.PENDENTE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class SolicitacaoAmizadeValidator {
    public void validar(SolicitacaoAmizade solicitacao) {
        if (solicitacao.getSituacao() != PENDENTE){
            throw new ResponseStatusException(BAD_REQUEST, "Essa solicitação já foi respondida");
        }
    }
}
