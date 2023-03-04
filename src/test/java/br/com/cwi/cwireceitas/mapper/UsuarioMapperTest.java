package br.com.cwi.cwireceitas.mapper;

import br.com.cwi.cwireceitas.factories.UsuarioFactory;
import br.com.cwi.cwireceitas.security.controller.request.UsuarioRequest;
import br.com.cwi.cwireceitas.security.controller.response.UsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.mapper.UsuarioMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class UsuarioMapperTest {

    @Test
    @DisplayName("Deve retornar response completo quando request completo")
    void deveRetornarResponseCompleto(){

        Usuario usuario = UsuarioFactory.get();

        UsuarioResponse response = UsuarioMapper.toResponse(usuario);

        Assertions.assertEquals(usuario.getId(), response.getId());
        Assertions.assertEquals(usuario.getNome(), response.getNome());
        Assertions.assertEquals(usuario.getEmail(), response.getEmail());
        Assertions.assertEquals(usuario.getApelido(), response.getApelido());
    }

    @Test
    @DisplayName("Deve retornar entidade completa quando request completa")
    void deveRetornarEntidadeCompleta(){

        UsuarioRequest request = new UsuarioRequest();
        request.setNome("Carlos Vinícius");
        request.setEmail("carlos.martins@cwi.com.br");
        request.setApelido("Vini");
        request.setDataNascimento(LocalDate.of(1998,07,23));
        request.setImagemPerfilUrl("http://www.foto.com.br");

        Usuario usuario = UsuarioMapper.toEntity(request);

        Assertions.assertEquals(request.getNome(),usuario.getNome());
        Assertions.assertEquals(request.getEmail(),usuario.getEmail());
        Assertions.assertEquals(request.getDataNascimento(),usuario.getDataNascimento());
        Assertions.assertEquals(request.getApelido(),usuario.getApelido());
        Assertions.assertEquals(request.getImagemPerfilUrl(),usuario.getImagemPerfilUrl());
    }
}
