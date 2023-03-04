package br.com.cwi.cwireceitas.security.service;

import br.com.cwi.cwireceitas.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.mapper.DetalharUsuarioMapper;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharUsuarioService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public DetalharUsuarioResponse detalhar(Long idUsuario) {
        Usuario usuario = buscarUsuarioService.porId(idUsuario);
        return DetalharUsuarioMapper.toResponse(usuario);
    }
}
