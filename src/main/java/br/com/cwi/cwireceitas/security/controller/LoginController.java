package br.com.cwi.cwireceitas.security.controller;

import br.com.cwi.cwireceitas.security.controller.response.UsuarioResponse;
import br.com.cwi.cwireceitas.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioAutenticadoService service;

    @PostMapping
    public UsuarioResponse login() {
        return service.getResponse();
    }
}

