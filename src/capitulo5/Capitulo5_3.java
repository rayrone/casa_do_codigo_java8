package capitulo5;

import capitulo2.Usuario;

import java.util.*;

public class Capitulo5_3 {

    public static void main(String[] args) {
        metodoOrdenacao1();
        metodoOrdenacao2();
        metodoOrdenacao3();
    }

    /* Ordenação com o método estático da interface Comparator */
    private static void metodoOrdenacao1() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //Comparator<Usuario> comparator = Comparator.comparing(u -> u.getNome());
        //usuarios.sort(comparator);

        usuarios.sort(Comparator.comparing(u -> u.getNome()));
        usuarios.forEach(System.out::println);
    }

    private static void metodoOrdenacao2() {
        List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");
        Collections.sort(palavras);
        palavras.forEach(System.out::println);
    }

    private static void metodoOrdenacao3() {
        List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");
        palavras.sort(Comparator.naturalOrder());
        //palavras.sort(Comparator.reverseOrder());
        palavras.forEach(System.out::println);
    }
}
