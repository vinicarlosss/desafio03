package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.controller.response.ListarPostsUsuarioResponse;
import br.com.cwi.cwireceitas.domain.Amizade;
import br.com.cwi.cwireceitas.domain.Post;
import br.com.cwi.cwireceitas.repository.PostRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarPostsService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;
    @Autowired
    private PostRepository postRepository;


    public Page<ListarPostsUsuarioResponse> listar(Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();


        return null;
    }
}
