package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.domain.Amizade;
import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import br.com.cwi.cwireceitas.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.cwireceitas.mapper.SolicitacaoAmizadeMapper;
import br.com.cwi.cwireceitas.repository.AmizadeRepository;
import br.com.cwi.cwireceitas.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import br.com.cwi.cwireceitas.service.search.BuscarSolicitacaoAmizadeService;
import br.com.cwi.cwireceitas.validator.SolicitacaoAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static br.com.cwi.cwireceitas.domain.Situacao.ACEITA;

@Service
public class AceitarSolicitacaoAmizadeService {

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
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public SolicitacaoAmizadeResponse aceitar(Long idSolicitacao) {

        SolicitacaoAmizade solicitacao = buscarSolicitacaoAmizadeService.porId(idSolicitacao);
        solicitacaoAmizadeValidator.validar(solicitacao);
        solicitacao.setSituacao(ACEITA);
        solicitacaoAmizadeRepository.save(solicitacao);
        Amizade amizade = Amizade.builder()
                .idUsuarioUm(solicitacao.getIdUsuarioSolicitado())
                .idUsuarioDois(solicitacao.getIdUsuarioSolicitante())
                .dataInicio(LocalDate.now())
                .build();

        amizadeRepository.save(amizade);

        Usuario usuarioUm = solicitacao.getIdUsuarioSolicitado();
        usuarioUm.adicionarAmizade(amizade);


        return SolicitacaoAmizadeMapper.toResponse(amizade);
    }
}
