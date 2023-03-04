package br.com.cwi.cwireceitas.controller;

import br.com.cwi.cwireceitas.controller.request.IncluirPostRequest;
import br.com.cwi.cwireceitas.controller.response.IncluirPostResponse;
import br.com.cwi.cwireceitas.controller.response.ListarPostsUsuarioResponse;
import br.com.cwi.cwireceitas.service.IncluirPostService;
import br.com.cwi.cwireceitas.service.ListarPostsOutroUsuarioService;
import br.com.cwi.cwireceitas.service.ListarPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IncluirPostService incluirPostService;
    @Autowired
    private ListarPostsOutroUsuarioService listarPostsOutroUsuarioService;
    @Autowired
    private ListarPostsService listarPostsService;


    @PostMapping("/incluir/{idUsuario}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    @ResponseStatus(CREATED)
    public IncluirPostResponse incluir(@PathVariable Long idUsuario, @Valid @RequestBody IncluirPostRequest request){
        return incluirPostService.incluir(idUsuario, request);
    }

    @GetMapping("/listar/{idUsuario}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    public Page<ListarPostsUsuarioResponse> listarPostOutroUsuario(@PathVariable Long idUsuario, Pageable pageable){
        return listarPostsOutroUsuarioService.listar(idUsuario, pageable);
    }

    @GetMapping("/listar")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    public Page<ListarPostsUsuarioResponse> listar(Pageable pageable){
        return listarPostsService.listar(pageable);
    }
}
