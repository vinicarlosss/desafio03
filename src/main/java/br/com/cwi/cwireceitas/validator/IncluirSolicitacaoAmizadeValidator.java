package br.com.cwi.cwireceitas.validator;

import br.com.cwi.cwireceitas.domain.Amizade;
import br.com.cwi.cwireceitas.domain.Situacao;
import br.com.cwi.cwireceitas.domain.SolicitacaoAmizade;
import br.com.cwi.cwireceitas.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.cwi.cwireceitas.domain.Situacao.PENDENTE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class IncluirSolicitacaoAmizadeValidator {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;


    public void validar(Usuario usuarioSolicitante, Usuario usuarioSolicitado) {

        if(usuarioSolicitante.getId() == usuarioSolicitado.getId()){
            throw new ResponseStatusException(BAD_REQUEST, "Não é possível solicitar amizade para si mesmo");
        }
        for(Amizade amizade:usuarioSolicitante.getAmizades()){
            if(amizade.getIdUsuarioUm().getId() == usuarioSolicitado.getId() ||
                    amizade.getIdUsuarioDois().getId() == usuarioSolicitado.getId()){
                throw new ResponseStatusException(BAD_REQUEST, "Esses usuários já são amigos.");
            }
        }
        if(solicitacaoAmizadeRepository.existsByIdUsuarioSolicitanteAndIdUsuarioSolicitado(usuarioSolicitante, usuarioSolicitado)){
            List<SolicitacaoAmizade> solicitacaoAmizade = solicitacaoAmizadeRepository.findAllByIdUsuarioSolicitanteAndIdUsuarioSolicitado(usuarioSolicitante,usuarioSolicitado);
            verificarJaExistente(solicitacaoAmizade);
            solicitacaoAmizade = solicitacaoAmizadeRepository.findAllByIdUsuarioSolicitanteAndIdUsuarioSolicitado(usuarioSolicitado,usuarioSolicitante);
            verificarJaExistente(solicitacaoAmizade);
        }

    }

    public void verificarJaExistente(List<SolicitacaoAmizade> solicitacaoAmizades){
        for(SolicitacaoAmizade solicitacao:solicitacaoAmizades){
            if(solicitacao.getSituacao() == PENDENTE){
                throw new ResponseStatusException(BAD_REQUEST, "Já existe uma solicitação de amizade para este usuário.");
            }
        }
    }

}
