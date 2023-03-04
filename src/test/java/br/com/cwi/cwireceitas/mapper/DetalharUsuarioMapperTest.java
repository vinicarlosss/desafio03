package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.factories.UsuarioFactory;
import br.com.cwi.cwireceitas.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.mapper.DetalharUsuarioMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DetalharUsuarioMapperTest {

    @InjectMocks
    private DetalharUsuarioMapper tested;

    @Test
    @DisplayName("Deve retornar o response completo")
    void deveRetornarResponse(){

        Usuario usuario = UsuarioFactory.get();
        DetalharUsuarioResponse response = tested.toResponse(usuario);

        assertEquals(response.getId(), usuario.getId());
        assertEquals(response.getNome(), usuario.getNome());
        assertEquals(response.getEmail(), usuario.getEmail());
        assertEquals(response.getApelido(), usuario.getApelido());
        assertEquals(response.getDataNascimento(), usuario.getDataNascimento());
        assertEquals(response.getImagemPerfilUrl(), usuario.getImagemPerfilUrl());
    }
}
