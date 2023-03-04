package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.controller.response.ListarAmizadesResponse;
import br.com.cwi.cwireceitas.mapper.ListarAmizadesMapper;
import br.com.cwi.cwireceitas.repository.AmizadeRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAmizadesService {

    @Autowired
    private AmizadeRepository amizadeRepository;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public Page<ListarAmizadesResponse> listar(Long idUsuario, Pageable pageable) {

        Usuario usuario = buscarUsuarioService.porId(idUsuario);
        if(amizadeRepository.existsByIdUsuarioUm(usuario)){
            return amizadeRepository.findAllByIdUsuarioUm(usuario, pageable)
                    .map(ListarAmizadesMapper::toResponse);
        }
        return amizadeRepository.findAllByIdUsuarioDois(usuario, pageable)
                .map(ListarAmizadesMapper::toResponse);
    }
}
