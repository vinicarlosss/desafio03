package br.com.cwi.cwireceitas.security.controller;

import br.com.cwi.cwireceitas.security.controller.request.AlterarUsuarioRequest;
import br.com.cwi.cwireceitas.security.controller.request.UsuarioRequest;
import br.com.cwi.cwireceitas.security.controller.response.AlterarUsuarioResponse;
import br.com.cwi.cwireceitas.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.cwireceitas.security.controller.response.UsuarioResponse;
import br.com.cwi.cwireceitas.security.service.AlterarUsuarioService;
import br.com.cwi.cwireceitas.security.service.DetalharUsuarioService;
import br.com.cwi.cwireceitas.security.service.IncluirUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;
    @Autowired
    private AlterarUsuarioService alterarUsuarioService;
    @Autowired
    private DetalharUsuarioService detalharUsuarioService;


    @PostMapping
    @ResponseStatus(CREATED)
    public UsuarioResponse incluir(@Valid  @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @PutMapping("/alterar/{idUsuario}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    @ResponseStatus(CREATED)
    public AlterarUsuarioResponse alterar(@PathVariable Long idUsuario, @Valid @RequestBody AlterarUsuarioRequest request){
        return alterarUsuarioService.alterar(idUsuario, request);
    }

    @GetMapping("/detalhar/{idUsuario}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    @ResponseStatus(CREATED)
    public DetalharUsuarioResponse detalhar(@PathVariable Long idUsuario){
        return detalharUsuarioService.detalhar(idUsuario);
    }
}

