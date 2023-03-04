package br.com.cwi.cwireceitas.service.core;

import br.com.cwi.cwireceitas.domain.Ingrediente;
import br.com.cwi.cwireceitas.factories.IngredienteFactory;
import br.com.cwi.cwireceitas.repository.IngredienteRespository;
import br.com.cwi.cwireceitas.service.register.CadastrarIngredienteService;
import br.com.cwi.cwireceitas.service.search.BuscarIngredienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarIngredienteServiceTest {

    @InjectMocks
    private CadastrarIngredienteService tested;
    @Mock
    private IngredienteRespository ingredienteRespository;
    @Mock
    private BuscarIngredienteService buscarIngredienteService;
    @Captor
    private ArgumentCaptor<Ingrediente> ingredienteCaptor;

    @Test
    @DisplayName("Deve cadastrar o ingrediente quando não estiver cadastrado")
    void deveCadastrarQuandoNaoCadastrado(){
        Ingrediente ingrediente = IngredienteFactory.get();
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(ingrediente);

        when(buscarIngredienteService.existByNome(ingrediente.getNome())).thenReturn(null);

        tested.cadastrar(ingredientes);

        verify(buscarIngredienteService).existByNome(ingrediente.getNome());
        verify(ingredienteRespository).save(ingredienteCaptor.capture());

        Ingrediente ingredienteCadastrado = ingredienteCaptor.getValue();

        assertEquals(ingrediente.getId(),ingredienteCadastrado.getId());
        assertEquals(ingrediente.getNome(),ingredienteCadastrado.getNome());
    }

    @Test
    @DisplayName("Não deve cadastrar ingrediente se ele já estiver cadastrado")
    void NaoDeveCadastrarQuandoJaCadastrado(){
        Ingrediente ingrediente = IngredienteFactory.get();

        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(ingrediente);

        when(buscarIngredienteService.existByNome(ingrediente.getNome())).thenReturn(ingrediente);

        tested.cadastrar(ingredientes);

        verify(buscarIngredienteService).existByNome(ingrediente.getNome());
        verify(ingredienteRespository, never()).save(ingrediente);

        assertEquals(ingrediente.getId(), ingredientes.get(0).getId());
        assertEquals(ingrediente.getNome(), ingredientes.get(0).getNome());
    }
}
