package capitulo4;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo4_2 {

    public static void main(String[] args) {

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> mostraMensagem = u -> System.out.println("antes de imprimir os nomes");
        Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

        // O método andThen pode ser usado para compor instâncias da interface Consumer
        // para que possam ser executadas sequencialmente
        usuarios.forEach(mostraMensagem.andThen(imprimeNome));
    }
}
