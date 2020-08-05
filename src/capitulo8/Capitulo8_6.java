package capitulo8;

import capitulo2.Usuario;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Capitulo8_6 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // Iterators em streams

        Iterator<Usuario> iterator = usuarios.stream().iterator();
        iterator.forEachRemaining(System.out::println);

        // Testando predicates

        boolean hasModerator = usuarios.stream()
                .anyMatch(Usuario::isModerador);

        System.out.println("Tem algum moderador? " + hasModerator);
        System.out.println("Todos são moderadores? " + usuarios.stream().allMatch(Usuario::isModerador));
        System.out.println("Nenhum é moderador? " + usuarios.stream().noneMatch(Usuario::isModerador));

    }
}
