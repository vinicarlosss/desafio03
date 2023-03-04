package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.controller.request.IncluirPostRequest;
import br.com.cwi.cwireceitas.controller.response.IncluirPostResponse;
import br.com.cwi.cwireceitas.domain.Post;
import br.com.cwi.cwireceitas.domain.Privacidade;
import br.com.cwi.cwireceitas.domain.Receita;
import br.com.cwi.cwireceitas.factories.ReceitaFactory;
import br.com.cwi.cwireceitas.factories.UsuarioFactory;
import br.com.cwi.cwireceitas.repository.PostRepository;
import br.com.cwi.cwireceitas.repository.ReceitaRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import br.com.cwi.cwireceitas.service.register.CadastrarIngredienteService;
import br.com.cwi.cwireceitas.validator.IncluirPostValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IncluirPostServiceTest {

    @InjectMocks
    private IncluirPostService tested;
    @Mock
    private PostRepository postRepository;
    @Mock
    private ReceitaRepository receitaRepository;
    @Mock
    private BuscarUsuarioService buscarUsuarioService;
    @Mock
    private CadastrarIngredienteService cadastrarIngredienteService;
    @Mock
    private IncluirPostValidator incluirPostValidator;
    @Captor
    private ArgumentCaptor<Post> postCaptor;

    @Test
    @DisplayName("Deve incluir post")
    void deveIncluirPost(){

        IncluirPostRequest request = new IncluirPostRequest();
        request.setPrivacidade(Privacidade.PUBLICO);
        request.setTitulo("Cocada");
        request.setDescricao("Como fazer cocada");
        request.setTempoPreparo(new Time(150));
        request.setIngredientes(new ArrayList<>());
        Usuario usuario = UsuarioFactory.get();
        Receita receita = ReceitaFactory.get();
        receita.setId(null);

        tested.incluir(usuario.getId(), request);

        verify(incluirPostValidator).validar(request);
        verify(receitaRepository).save(receita);
        verify(postRepository).save(postCaptor.capture());

        Post post = postCaptor.getValue();

        assertEquals(request.getTitulo(), post.getIdReceita().getTitulo());
        assertEquals(request.getDescricao(), post.getIdReceita().getDescricao());
        assertEquals(request.getPrivacidade(), post.getPrivacidade());
        assertEquals(request.getTempoPreparo(), post.getIdReceita().getTempo_preparo());
        assertEquals(request.getIngredientes(), post.getIdReceita().getIngredientes());
    }
}
