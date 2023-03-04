package br.com.cwi.cwireceitas.security.validator;

import br.com.cwi.cwireceitas.security.controller.request.UsuarioRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class IncluirUsuarioValidator {
    public static final int TAMANHO_MINIMO_NOME = 5;
    public static final int TAMANHO_MINIMO_SENHA = 4;
    public static final int TAMANHO_MINIMO_APELIDO = 3;
    public static final int TAMANHO_MINIMO_URL = 15;
    public static final int EXISTE_ALGO_NO_CAMPO = 1;

    public void validar(UsuarioRequest request) {

        if(isNull(request)){
            throw new ResponseStatusException(BAD_REQUEST, "Dados não informados");
        }

        if(request.getNome().trim().length() < TAMANHO_MINIMO_NOME){
            throw new ResponseStatusException(BAD_REQUEST, "Nome precisa ter no mínimo 4 caracteres");
        }

        if(request.getSenha().trim().length() < TAMANHO_MINIMO_SENHA){
            throw new ResponseStatusException(BAD_REQUEST, "Senha precisa ter no mínimo 4 caracteres");
        }

        if(request.getApelido().trim().length() < TAMANHO_MINIMO_APELIDO
                && request.getApelido().trim().length() >= EXISTE_ALGO_NO_CAMPO){
            throw new ResponseStatusException(BAD_REQUEST, "Apelido precisa ter no mínimo 3 caracteres");
        }

        if(request.getImagemPerfilUrl().trim().length() < TAMANHO_MINIMO_URL
                && request.getImagemPerfilUrl().trim().length() >= EXISTE_ALGO_NO_CAMPO){
            throw new ResponseStatusException(BAD_REQUEST, "Url de imagem do perfil deve ter no mínimo 15 caracteres");
        }

        if(isNull(request.getDataNascimento())){
            throw new ResponseStatusException(BAD_REQUEST, "Data de nascimento é obrigatória");
        }
    }
}
