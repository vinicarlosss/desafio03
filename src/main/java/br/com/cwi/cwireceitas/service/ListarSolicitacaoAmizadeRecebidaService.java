package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.controller.response.ListarSolicitacaoAmizadeRecebidaResponse;
import br.com.cwi.cwireceitas.mapper.ListarSolicitacaoAmizadeRecebidaMapper;
import br.com.cwi.cwireceitas.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarSolicitacaoAmizadeRecebidaService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;
    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public Page<ListarSolicitacaoAmizadeRecebidaResponse> listar(Pageable pageable) {
        Usuario usuario = usuarioAutenticadoService.get();
        return solicitacaoAmizadeRepository.findAllByIdUsuarioSolicitado(usuario, pageable)
                .map(ListarSolicitacaoAmizadeRecebidaMapper::toResponse);
    }
}
