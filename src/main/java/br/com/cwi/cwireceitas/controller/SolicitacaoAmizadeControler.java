package br.com.cwi.cwireceitas.controller;

import br.com.cwi.cwireceitas.controller.response.IncluirSolicitacaoAmizadeResponse;
import br.com.cwi.cwireceitas.controller.response.ListarSolicitacaoAmizadeRecebidaResponse;
import br.com.cwi.cwireceitas.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.cwireceitas.service.AceitarSolicitacaoAmizadeService;
import br.com.cwi.cwireceitas.service.ListarSolicitacaoAmizadeRecebidaService;
import br.com.cwi.cwireceitas.service.IncluirSolicitacaoAmizadeService;
import br.com.cwi.cwireceitas.service.RecusarSolicitacaoAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/solicitacoesAmizades")
public class SolicitacaoAmizadeControler {

    @Autowired
    private ListarSolicitacaoAmizadeRecebidaService listarSolicitacaoAmizadeRecebidaService;
    @Autowired
    private IncluirSolicitacaoAmizadeService incluirSolicitacaoAmizadeService;
    @Autowired
    private AceitarSolicitacaoAmizadeService aceitarSolicitacaoAmizadeService;
    @Autowired
    private RecusarSolicitacaoAmizadeService recusarSolicitacaoAmizadeService;


    @GetMapping("/listar")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    @ResponseStatus(CREATED)
    public Page<ListarSolicitacaoAmizadeRecebidaResponse> listar(Pageable pageable){
        return listarSolicitacaoAmizadeRecebidaService.listar(pageable);
    }

    @PostMapping("/incluir/{idUsuarioSolicitado}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    @ResponseStatus(CREATED)
    public IncluirSolicitacaoAmizadeResponse incluir(@PathVariable Long idUsuarioSolicitado){
        return incluirSolicitacaoAmizadeService.incluir(idUsuarioSolicitado);
    }

    @PostMapping("/aceitar/{idSolicitacao}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    @ResponseStatus(CREATED)
    public SolicitacaoAmizadeResponse aceitar(@PathVariable Long idSolicitacao){
        return aceitarSolicitacaoAmizadeService.aceitar(idSolicitacao);
    }

    @PostMapping("/recusar/{idSolicitacao}")
    @Secured({"ROLE_USUARIO", "ROLE_ADMIN"})
    @ResponseStatus(CREATED)
    public void recusar(@PathVariable Long idSolicitacao){
        recusarSolicitacaoAmizadeService.recusar(idSolicitacao);
    }
}
