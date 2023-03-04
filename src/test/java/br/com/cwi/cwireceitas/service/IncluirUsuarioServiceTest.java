package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.security.controller.request.UsuarioRequest;
import br.com.cwi.cwireceitas.security.controller.response.UsuarioResponse;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import br.com.cwi.cwireceitas.security.service.IncluirUsuarioService;
import br.com.cwi.cwireceitas.security.service.validator.ValidaEmailUnicoService;
import br.com.cwi.cwireceitas.security.validator.IncluirUsuarioValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class IncluirUsuarioServiceTest {

    @InjectMocks
    private IncluirUsuarioService tested;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private ValidaEmailUnicoService validaEmailUnicoService;
    @Mock
    private IncluirUsuarioValidator incluirUsuarioValidator;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Deve incluir novo usuário com nome, email e apelido passados")
    void deveIncluirUsuario(){

        UsuarioRequest request = new UsuarioRequest();
        request.setNome("Carlos Vinícius");
        request.setApelido("Vini");
        request.setEmail("carlos.martins@cwi.com.br");
        request.setDataNascimento(LocalDate.of(1998,07,23));
        request.setSenha("1998");

        Usuario usuario = new Usuario();

        UsuarioResponse usuarioIncluido = tested.incluir(request);

        assertEquals(request.getNome(), usuarioIncluido.getNome());
        assertEquals(request.getEmail(), usuarioIncluido.getEmail());
        assertEquals(request.getApelido(), usuarioIncluido.getApelido());

        verify(validaEmailUnicoService).validar(request.getEmail());
        verify(incluirUsuarioValidator).validar(request);
        verify(usuarioRepository).save(usuario);
    }

    @Test
    @DisplayName("Deve incluir usuario com apelido nulo se não for passado")
    void deveIncluirUsuarioComApelidoNulo(){

        UsuarioRequest request = new UsuarioRequest();
        request.setNome("Carlos Vinícius");
        request.setEmail("carlos.martins@cwi.com.br");
        request.setDataNascimento(LocalDate.of(1998,07,23));
        request.setSenha("1998");

        Usuario usuario = new Usuario();
        UsuarioResponse usuarioIncluido = tested.incluir(request);

        assertNull(usuarioIncluido.getApelido());

        verify(validaEmailUnicoService).validar(request.getEmail());
        verify(incluirUsuarioValidator).validar(request);
        verify(usuarioRepository).save(usuario);
    }
}
