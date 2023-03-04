package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.controller.response.ListarPostsUsuarioResponse;
import br.com.cwi.cwireceitas.domain.Amizade;
import br.com.cwi.cwireceitas.mapper.ListarPostsUsuarioMapper;
import br.com.cwi.cwireceitas.repository.PostRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.UsuarioAutenticadoService;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static br.com.cwi.cwireceitas.domain.Privacidade.PUBLICO;

@Service
public class ListarPostsOutroUsuarioService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;
    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;
    @Autowired
    private PostRepository postRepository;

    public Page<ListarPostsUsuarioResponse> listar(Long idUsuario, Pageable pageable) {
        Usuario usuario = buscarUsuarioService.porId(idUsuario);
        Usuario usuarioLogado = usuarioAutenticadoService.get();
        for(Amizade amizade:usuarioLogado.getAmizades()){
            if(amizade.getIdUsuarioUm().getId() == usuario.getId() || amizade.getIdUsuarioDois().getId() == usuario.getId()){
                return postRepository.findAllByIdUsuario(usuario, pageable)
                        .map(ListarPostsUsuarioMapper::toResponse);
            }
        }
        return postRepository.findAllByIdUsuarioAndPrivacidade(usuario, PUBLICO, pageable)
                .map(ListarPostsUsuarioMapper::toResponse);
    }
}
