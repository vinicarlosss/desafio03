package br.com.cwi.cwireceitas.security.service;

import br.com.cwi.cwireceitas.security.controller.request.AlterarUsuarioRequest;
import br.com.cwi.cwireceitas.security.controller.response.AlterarUsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import br.com.cwi.cwireceitas.security.validator.AlterarUsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.cwireceitas.security.mapper.AlterarUsuarioMapper.toResponse;

@Service
public class AlterarUsuarioService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AlterarUsuarioValidator alterarUsuarioValidator;

    @Transactional
    public AlterarUsuarioResponse alterar(Long idUsuario, AlterarUsuarioRequest request) {

        alterarUsuarioValidator.validar(request);
        Usuario usuario = buscarUsuarioService.porId(idUsuario);
        usuario.setNome(request.getNome());
        usuario.setApelido(request.getApelido());
        usuario.setImagemPerfilUrl(request.getImagemPerfilUrl());

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
