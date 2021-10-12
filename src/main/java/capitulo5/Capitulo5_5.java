package capitulo5;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Capitulo5_5 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //metodoOrdenacao8(usuarios);
        metodoOrdenacao9(usuarios);
    }

    /* Ordenação usando autoboxing nas lambdas (desnecessariamente) */
    private static void metodoOrdenacao8(List<Usuario> usuarios) {

        /*Function<Usuario, Integer> extraiPontos = u -> u.getPontos();
        Comparator<Usuario> comparator = Comparator.comparing(extraiPontos);
        usuarios.sort(comparator);*/

        usuarios.sort(Comparator.comparing(u -> u.getPontos()));
        usuarios.forEach(System.out::println);
    }

    /* Ordenação evitando autoboxing desnecessário nas lambdas */
    private static void metodoOrdenacao9(List<Usuario> usuarios) {

        /*ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
        Comparator<Usuario> comparator = Comparator.comparingInt(extraiPontos);
        usuarios.sort(comparator);*/

        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));
        usuarios.forEach(System.out::println);
    }
}
