package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.factories.UsuarioFactory;
import br.com.cwi.cwireceitas.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.DetalharUsuarioService;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DetalharUsuarioServiceTest {

    @InjectMocks
    private DetalharUsuarioService tested;
    @Mock
    private BuscarUsuarioService buscarUsuarioService;

    @Test
    @DisplayName("Deve retornar usuário completo")
    void deveRetornarUsuario(){

        Usuario usuario= UsuarioFactory.get();

        when(buscarUsuarioService.porId(usuario.getId())).thenReturn(usuario);

        DetalharUsuarioResponse response = tested.detalhar(usuario.getId());

        assertEquals(response.getId(), usuario.getId());
        assertEquals(response.getNome(), usuario.getNome());
        assertEquals(response.getEmail(), usuario.getEmail());
        assertEquals(response.getApelido(), usuario.getApelido());
        assertEquals(response.getDataNascimento(), usuario.getDataNascimento());
        assertEquals(response.getImagemPerfilUrl(), usuario.getImagemPerfilUrl());

        verify(buscarUsuarioService).porId(usuario.getId());
    }
}
