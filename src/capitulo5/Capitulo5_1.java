package capitulo5;

import capitulo2.Usuario;

import java.util.*;

public class Capitulo5_1 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

//        metodoOrdenacao1(usuarios);
//        metodoOrdenacao2(usuarios);
        metodoOrdenacao3(usuarios);
    }

    /* Ordenação com a instanciação de uma classe anônima */
    private static void metodoOrdenacao1(List<Usuario> usuarios) {
        Comparator<Usuario> comparator = new Comparator<>() {
            public int compare(Usuario u1, Usuario u2) {
                //return u1.getNome().compareTo(u2.getNome());
                return String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(), u2.getNome());
            }
        };

        Collections.sort(usuarios, comparator);

        usuarios.forEach(System.out::println);
    }

    /* Ordenação com a instanciação de uma classe anônima usando lamba */
    private static void metodoOrdenacao2(List<Usuario> usuarios) {
        Comparator<Usuario> comparator2 = (u1, u2) -> u1.getNome().compareTo(u2.getNome());
        Collections.sort(usuarios, comparator2);
        usuarios.forEach(System.out::println);
    }

    /* Ordenação com a instanciação de uma classe anônima usando lamba e sem variável local */
    private static void metodoOrdenacao3(List<Usuario> usuarios) {
        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));
        usuarios.forEach(System.out::println);
    }
}
