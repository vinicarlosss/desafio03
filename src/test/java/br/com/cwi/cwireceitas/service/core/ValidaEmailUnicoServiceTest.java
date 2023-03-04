package br.com.cwi.cwireceitas.service.core;

import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import br.com.cwi.cwireceitas.security.service.validator.ValidaEmailUnicoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidaEmailUnicoServiceTest {

    @InjectMocks
    private ValidaEmailUnicoService tested;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve não fazer nada quando email for único")
    void deveFazerNadaSeEmailUnico(){

        String email = "carlos.martins@cwi.com.br";
        when(usuarioRepository.existsByEmail(email)).thenReturn(false);

        tested.validar(email);
        verify(usuarioRepository).existsByEmail(email);
    }

    @Test
    @DisplayName("Deve retornar erro quando existir outro usuário com o mesmo email")
    void deveRetornarErroQuantoEmailDuplicado(){

        String email = "carlos.martins@cwi.com.br";
        when(usuarioRepository.existsByEmail(email)).thenReturn(true);

        ResponseStatusException exception =
                Assertions.assertThrows(ResponseStatusException.class, () ->tested.validar(email));

        Assertions.assertEquals("Já existe um usuário cadastrado com esse email", exception.getReason());
    }
}
