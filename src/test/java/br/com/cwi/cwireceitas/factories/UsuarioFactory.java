package br.com.cwi.cwireceitas.factories;

import br.com.cwi.cwireceitas.security.domain.Usuario;

import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario get(){
        Usuario usuario = new Usuario();
        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNome("Carlos Vinícius");
        usuario.setEmail("carlos.martins@cwi.com.br");
        usuario.setDataNascimento(LocalDate.of(1998,07,23));
        usuario.setImagemPerfilUrl("http://www.foto.com.br");
        usuario.setApelido("Vini");
        usuario.setAtivo(true);

        return usuario;
    }
}
