package capitulo7;

import capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Capitulo7_6 {

    /* Utilizando o método map para processar os elementos de um stream */
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //List<Integer> pontos = usuarios.stream().map(u -> u.getPontos()).collect(Collectors.toList());
        List<Integer> pontos = usuarios.stream().map(Usuario::getPontos).collect(Collectors.toList());

        System.out.println(pontos);
    }
}
