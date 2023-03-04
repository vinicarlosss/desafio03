package br.com.cwi.cwireceitas.controller;

import br.com.cwi.cwireceitas.controller.response.ListarAmizadesResponse;
import br.com.cwi.cwireceitas.service.ListarAmizadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    @Autowired
    private ListarAmizadesService listarAmizadesService;

    @GetMapping("/listar/{idUsuario}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    public Page<ListarAmizadesResponse> listar(@PathVariable Long idUsuario, Pageable pageable){
        return listarAmizadesService.listar(idUsuario, pageable);
    }
}
