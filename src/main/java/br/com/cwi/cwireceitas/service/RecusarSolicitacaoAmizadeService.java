package br.com.cwi.cwireceitas.service;


import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import br.com.cwi.cwireceitas.repository.AmizadeRepository;
import br.com.cwi.cwireceitas.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import br.com.cwi.cwireceitas.service.search.BuscarSolicitacaoAmizadeService;
import br.com.cwi.cwireceitas.validator.SolicitacaoAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.cwireceitas.domain.Situacao.RECUSADA;

@Service
public class RecusarSolicitacaoAmizadeService {

    @Autowired
    private BuscarSolicitacaoAmizadeService buscarSolicitacaoAmizadeService;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;
    @Autowired
    private AmizadeRepository amizadeRepository;
    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;
    @Autowired
    private SolicitacaoAmizadeValidator solicitacaoAmizadeValidator;

    public void recusar(Long idSolicitacao) {
        SolicitacaoAmizade solicitacao = buscarSolicitacaoAmizadeService.porId(idSolicitacao);
        solicitacaoAmizadeValidator.validar(solicitacao);
        solicitacao.setSituacao(RECUSADA);

        solicitacaoAmizadeRepository.save(solicitacao);
    }
}
