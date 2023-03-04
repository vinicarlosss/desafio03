package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.factories.UsuarioFactory;
import br.com.cwi.cwireceitas.security.controller.response.AlterarUsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.cwi.cwireceitas.security.mapper.AlterarUsuarioMapper.toResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AlterarUsuarioMapperTest {

    @Test
    @DisplayName("Deve retornar response com id, nome, apelido e url de imagem do perfil")
    void deveRetornarResponseCompleto(){

        Usuario usuario = UsuarioFactory.get();

        AlterarUsuarioResponse response = toResponse(usuario);

        assertEquals(usuario.getId(), response.getId());
        assertEquals(usuario.getNome(), response.getNome());
        assertEquals(usuario.getApelido(), response.getApelido());
        assertEquals(usuario.getImagemPerfilUrl(), response.getImagemPerfilUrl());
    }
}
