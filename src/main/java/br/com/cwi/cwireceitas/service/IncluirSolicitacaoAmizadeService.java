package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.controller.request.IncluirSolicitacaoAmizadeRequest;
import br.com.cwi.cwireceitas.controller.response.IncluirSolicitacaoAmizadeResponse;
import br.com.cwi.cwireceitas.domain.Situacao;
import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import br.com.cwi.cwireceitas.mapper.IncluirSolicitacaoAmizadeMapper;
import br.com.cwi.cwireceitas.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.UsuarioAutenticadoService;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import br.com.cwi.cwireceitas.validator.IncluirSolicitacaoAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static br.com.cwi.cwireceitas.domain.Situacao.PENDENTE;
import static br.com.cwi.cwireceitas.mapper.IncluirSolicitacaoAmizadeMapper.toResponse;

@Service
public class IncluirSolicitacaoAmizadeService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;
    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;
    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;
    @Autowired
    private IncluirSolicitacaoAmizadeValidator incluirSolicitacaoAmizadeValidator;

    @Transactional
    public IncluirSolicitacaoAmizadeResponse incluir(Long idUsuarioSolicitado) {

        Long idUsuarioSolicitante = usuarioAutenticadoService.getId();
        Usuario usuarioSolicitado = buscarUsuarioService.porId(idUsuarioSolicitado);
        Usuario usuarioSolicitante = buscarUsuarioService.porId(idUsuarioSolicitante);

        incluirSolicitacaoAmizadeValidator.validar(usuarioSolicitado, usuarioSolicitante);

        if(solicitacaoAmizadeRepository.existsByIdUsuarioSolicitanteAndIdUsuarioSolicitado(usuarioSolicitante,
                usuarioSolicitado)){
            SolicitacaoAmizade solicitacaoAmizade = solicitacaoAmizadeRepository.
                    findByIdUsuarioSolicitanteAndIdUsuarioSolicitado(usuarioSolicitante, usuarioSolicitado);
            solicitacaoAmizade.setSituacao(PENDENTE);

            solicitacaoAmizadeRepository.save(solicitacaoAmizade);

            return toResponse(solicitacaoAmizade);
        }if(solicitacaoAmizadeRepository.existsByIdUsuarioSolicitanteAndIdUsuarioSolicitado(
                usuarioSolicitado,usuarioSolicitante)){
            SolicitacaoAmizade solicitacaoAmizade = solicitacaoAmizadeRepository.
                    findByIdUsuarioSolicitanteAndIdUsuarioSolicitado(usuarioSolicitado, usuarioSolicitante);
            solicitacaoAmizade.setSituacao(PENDENTE);

            solicitacaoAmizadeRepository.save(solicitacaoAmizade);

            return toResponse(solicitacaoAmizade);
        }
        SolicitacaoAmizade solicitacaoAmizade = new SolicitacaoAmizade();
        solicitacaoAmizade.setDataSolicitacao(LocalDate.now());
        solicitacaoAmizade.setIdUsuarioSolicitado(usuarioSolicitado);
        solicitacaoAmizade.setIdUsuarioSolicitante(usuarioSolicitante);
        solicitacaoAmizade.setSituacao(Situacao.PENDENTE);

        solicitacaoAmizadeRepository.save(solicitacaoAmizade);

        return toResponse(solicitacaoAmizade);
    }
}
