package br.com.cwi.cwireceitas.service.core;

import br.com.cwi.cwireceitas.factories.UsuarioFactory;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarUsuarioServiceTest {

    @InjectMocks
    private BuscarUsuarioService tested;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve retornar o usuário caso passado id correto")
    void deveRetornarUsuario(){

        Usuario usuario = UsuarioFactory.get();
        Long idUsuario = usuario.getId();

        when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuario));

        Usuario retorno = tested.porId(idUsuario);

        assertEquals(usuario, retorno);
        verify(usuarioRepository).findById(idUsuario);
    }

    @Test
    @DisplayName("Deve retornar erro quando não encontrar usuário")
    void deveRetornarErro(){
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested.porId(1L));
        assertEquals("Usuário não encontrado", exception.getReason());
    }
}
