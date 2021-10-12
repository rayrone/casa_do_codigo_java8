package capitulo2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        // Arrays.asList é uma maneira simples de criar uma List imutável
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // Método de iterar sobre um array ou coleção desde o Java 5
        for (Usuario u : usuarios)
            System.out.println(u.getNome());

        // Método de iterar sobre um array ou coleção no Java 8
        // Usando uma classe que implementa a interface Consumer
        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);

        // Método de iterar sobre um array ou coleção no Java 8
        // Usando uma classe anônima que implementa a interface Consumer
        Consumer<Usuario> mostrador2 = new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };
        usuarios.forEach(mostrador2);

        // Método de iterar sobre um array ou coleção no Java 8
        // Usando uma classe anônima que implementa a interface Consumer (sem a variável mostrador)
        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        });

        // Método de iterar sobre um array ou coleção no Java 8
        // Usando lambda expression com tipo capitulo2.Usuario explícito
        Consumer<Usuario> mostrador3 = (Usuario u) -> {
            System.out.println(u.getNome());
        };
        usuarios.forEach(mostrador3);

        // Método de iterar sobre um array ou coleção no Java 8
        // Usando lambda expression com inferência de tipo
        Consumer<Usuario> mostrador4 = u -> {
            System.out.println(u.getNome());
        };
        usuarios.forEach(mostrador4);

        // Método de iterar sobre um array ou coleção no Java 8
        // Usando lambda expression com inferência de tipo - sem chaves porque é uma instrução uma linha só
        Consumer<Usuario> mostrador5 = u -> System.out.println(u.getNome());
        usuarios.forEach(mostrador5);

        // Método de iterar sobre um array ou coleção no Java 8
        // Usando lambda expression com inferência de tipo - sem chaves porque é uma instrução uma linha só
        usuarios.forEach(u -> System.out.println(u.getNome()));

        // Tornando todos os usuário moderadores
        usuarios.forEach(u -> u.tornarModerador());
    }
}
