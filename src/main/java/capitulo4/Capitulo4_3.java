package capitulo4;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Capitulo4_3 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios2 = new ArrayList<>();
        usuarios2.add(user1);
        usuarios2.add(user2);
        usuarios2.add(user3);

        // Predicado sem lambda
//        Predicate<Usuario> predicado = new Predicate<Usuario>() {
//            @Override
//            public boolean test(Usuario usuario) {
//                return usuario.getPontos() > 160;
//            }
//        };
//
//        System.out.println("\nUsuário depois da remoção");
//        usuarios2.removeIf(predicado);
//        usuarios2.forEach(System.out::println);

        // Predicado com lambda
        System.out.println("\nUsuário depois da remoção com lambda");
        usuarios2.removeIf(u -> u.getPontos() > 160);
        usuarios2.forEach(System.out::println);
    }
}
