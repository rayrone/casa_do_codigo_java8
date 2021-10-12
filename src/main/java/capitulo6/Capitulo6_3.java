package capitulo6;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Capitulo6_3 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Rayrone Marques", 190);
        Usuario user4 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);

//        metodoOrdenacao1(usuarios);
//        metodoOrdenacao2(usuarios);
//        metodoOrdenacao3(usuarios);
        metodoOrdenacao4(usuarios);
    }

    /* Ordenação com a composição de comparators */
    private static void metodoOrdenacao1(List<Usuario> usuarios) {
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));
        usuarios.forEach(System.out::println);
    }

    /* Ordenação com a composição de comparators com NullLast */
    private static void metodoOrdenacao2(List<Usuario> usuarios) {
        usuarios.add(0, null);
        usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario::getNome)));
        usuarios.forEach(System.out::println);
    }

    /* Ordenação com a composição de comparators com NullFirst */
    private static void metodoOrdenacao3(List<Usuario> usuarios) {
        usuarios.add(null);
        usuarios.sort(Comparator.nullsFirst(Comparator.comparing(Usuario::getNome)));
        usuarios.forEach(System.out::println);
    }

    /* Ordenação em ordem inversa */
    private static void metodoOrdenacao4(List<Usuario> usuarios) {
        usuarios.sort(Comparator.comparing(Usuario::getNome).reversed());
        usuarios.forEach(System.out::println);
    }
}
