package capitulo6;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Capitulo6_2 {

    /* Ordenação com o método estático da interface Comparator e Method Reference */
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        usuarios.sort(Comparator.comparing(Usuario::getNome));
        usuarios.forEach(System.out::println);
    }
}
