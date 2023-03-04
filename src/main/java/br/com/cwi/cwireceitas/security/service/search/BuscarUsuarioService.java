package br.com.cwi.cwireceitas.security.service.search;

import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario porId(Long idUsuario) {
        return usuarioRepository
                .findById(idUsuario)
                .orElseThrow(()-> new ResponseStatusException(BAD_REQUEST, "Usuário não encontrado"));
    }
}
