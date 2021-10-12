package capitulo6;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capitulo6_1 {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // Tornando todos usuários moderadores com expressão lambda
        // usuarios.forEach(u -> u.tornarModerador());

        // Tornando todos usuários moderadores com Method Reference
        usuarios.forEach(Usuario::tornarModerador);
    }
}
