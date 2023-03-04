package br.com.cwi.cwireceitas.security.service;

import br.com.cwi.cwireceitas.security.controller.request.UsuarioRequest;
import br.com.cwi.cwireceitas.security.controller.response.UsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Permissao;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import br.com.cwi.cwireceitas.security.service.validator.ValidaEmailUnicoService;
import br.com.cwi.cwireceitas.security.validator.IncluirUsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.cwireceitas.security.domain.Funcao.USUARIO;
import static br.com.cwi.cwireceitas.security.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.cwireceitas.security.mapper.UsuarioMapper.toResponse;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ValidaEmailUnicoService validaEmailUnicoService;
    @Autowired
    private IncluirUsuarioValidator incluirUsuarioValidator;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponse incluir(UsuarioRequest request) {

        incluirUsuarioValidator.validar(request);
        validaEmailUnicoService.validar(request.getEmail());

        Usuario usuario = toEntity(request);
        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
        usuario.adicionarPermissao(getPermissaoPadrao());
        usuario.setAtivo(true);

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

    private Permissao getPermissaoPadrao() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }


}
