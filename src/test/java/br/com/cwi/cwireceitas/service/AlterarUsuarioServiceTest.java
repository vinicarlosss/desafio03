package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.factories.UsuarioFactory;
import br.com.cwi.cwireceitas.security.controller.request.AlterarUsuarioRequest;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.repository.UsuarioRepository;
import br.com.cwi.cwireceitas.security.service.AlterarUsuarioService;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import br.com.cwi.cwireceitas.security.validator.AlterarUsuarioValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlterarUsuarioServiceTest {

    @InjectMocks
    private AlterarUsuarioService tested;
    @Mock
    private BuscarUsuarioService buscarUsuarioService;
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private AlterarUsuarioValidator alterarUsuarioValidator;
    @Captor
    private ArgumentCaptor<Usuario> usuarioCaptor;

    @Test
    @DisplayName("Deve alterar nome obrigatoriamente e alterar apelido e url da imagem do perfil quando passados")
    void deveAlterarNomeApelidoImagemPerfilURL(){

        Usuario usuario = UsuarioFactory.get();
        Long idUsuario = usuario.getId();
        AlterarUsuarioRequest request = new AlterarUsuarioRequest();
        request.setNome("Eduardo Ferreira dos Santos");
        request.setApelido("Edu");
        request.setImagemPerfilUrl("htttp://www.fotoEdu.com.br");

        when(buscarUsuarioService.porId(idUsuario)).thenReturn(usuario);

        tested.alterar(idUsuario, request);

        verify(usuarioRepository).save(usuarioCaptor.capture());
        verify(alterarUsuarioValidator).validar(request);

        Usuario usuarioAlterado = usuarioCaptor.getValue();

        assertEquals(request.getNome(), usuarioAlterado.getNome());
        assertEquals(request.getApelido(), usuarioAlterado.getApelido());
        assertEquals(request.getImagemPerfilUrl(), usuarioAlterado.getImagemPerfilUrl());
    }
}
