package br.com.cwi.cwireceitas.service;

import br.com.cwi.cwireceitas.controller.request.IncluirPostRequest;
import br.com.cwi.cwireceitas.controller.response.IncluirPostResponse;
import br.com.cwi.cwireceitas.domain.Ingrediente;
import br.com.cwi.cwireceitas.domain.Post;
import br.com.cwi.cwireceitas.domain.Receita;
import br.com.cwi.cwireceitas.mapper.IncluirIngredienteMapper;
import br.com.cwi.cwireceitas.repository.PostRepository;
import br.com.cwi.cwireceitas.repository.ReceitaRepository;
import br.com.cwi.cwireceitas.security.domain.Usuario;
import br.com.cwi.cwireceitas.security.service.search.BuscarUsuarioService;
import br.com.cwi.cwireceitas.service.register.CadastrarIngredienteService;
import br.com.cwi.cwireceitas.validator.IncluirPostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.cwi.cwireceitas.mapper.IncluirPostMapper.toEntity;
import static br.com.cwi.cwireceitas.mapper.IncluirPostMapper.toResponse;
import static br.com.cwi.cwireceitas.mapper.IncluirReceitaMapper.toEntity;
import static java.util.Objects.isNull;

@Service
public class IncluirPostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;
    @Autowired
    private CadastrarIngredienteService cadastrarIngredienteService;
    @Autowired
    private IncluirPostValidator incluirPostValidator;

    @Transactional
    public IncluirPostResponse incluir(Long idUsuario, IncluirPostRequest request) {

        incluirPostValidator.validar(request);
        List<Ingrediente> ingredientes = request.getIngredientes().stream()
                .map(IncluirIngredienteMapper::toEntity).collect(Collectors.toList());
        List<Ingrediente> ingredientesCadastrar = cadastrarIngredienteService.cadastrar(ingredientes);

        Receita receita = toEntity(request, ingredientesCadastrar);

        receitaRepository.save(receita);

        Usuario usuario = buscarUsuarioService.porId(idUsuario);
        Post post = toEntity(request, receita, usuario);

        postRepository.save(post);

        return toResponse(post);
    }
}
