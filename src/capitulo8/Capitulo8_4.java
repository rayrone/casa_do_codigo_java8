package capitulo8;

import capitulo2.Usuario;

import java.util.*;
import java.util.stream.Collectors;

public class Capitulo8_4 {

    /* Enxergando a execução do pipeline com peek */
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

//        usuarios.stream()
//                .filter(u -> u.getPontos() > 100)
//                .peek(System.out::println)
//                .findAny();

        usuarios.stream()
                .sorted(Comparator.comparing(Usuario::getNome))
                .peek(System.out::println)
                .findAny();
    }
}
