package capitulo7;

import capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Capitulo7_2 {

    /* Tornando moderadores os usuários com mais 100 pontos */
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        usuarios.stream().filter(u -> u.getPontos() > 100).forEach(Usuario::tornarModerador);

        //Stream<Usuario> moderadores = usuarios.stream().filter(u -> u.isModerador());
        Stream<Usuario> moderadores = usuarios.stream().filter(Usuario::isModerador);

        moderadores.forEach(System.out::println);
    }
}
