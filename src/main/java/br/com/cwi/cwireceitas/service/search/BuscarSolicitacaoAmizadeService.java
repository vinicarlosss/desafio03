package br.com.cwi.cwireceitas.service.search;

import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import br.com.cwi.cwireceitas.repository.SolicitacaoAmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarSolicitacaoAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    public SolicitacaoAmizade porId(Long idSolicitacao) {
        return solicitacaoAmizadeRepository.findById(idSolicitacao)
                .orElseThrow(()->new ResponseStatusException(BAD_REQUEST, "Solicitação não encontrada"));
    }
}
