package capitulo7;

import capitulo2.Usuario;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Capitulo7_4 {

    /* Coletando os resultados após a filtragem - Interface Collector */
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        final Stream<Usuario> stream = usuarios.stream()
                .filter(u -> u.getPontos() > 100);

        List<Usuario> maisQue100 = stream.collect(Collectors.toList());
        maisQue100.forEach(System.out::println);

        Set<Usuario> maisQue100_2 = stream.collect(Collectors.toSet());
        maisQue100_2.forEach(System.out::println);

        Set<Usuario> maisQue100_3 = stream.collect(Collectors.toCollection(HashSet::new));
        maisQue100_3.forEach(System.out::println);
    }
}
