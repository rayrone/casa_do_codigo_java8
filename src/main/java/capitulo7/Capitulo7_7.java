package capitulo7;

import capitulo2.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo7_7 {

    /* Utilizando o método map para processar os elementos de um stream - sem autoboxing */
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        // Usando mapToInt para evitar autoboxing
        IntStream stream1 = usuarios.stream().mapToInt(Usuario::getPontos);

        int totalDePontos = stream1.sum();
        System.out.println("Total de Pontos: " + totalDePontos);

        // O stream não pode ser reaproveitado, por isso temos que criar um novo
        IntStream stream2 = usuarios.stream().mapToInt(Usuario::getPontos);

        double pontuacaoMedia = stream2.average().getAsDouble();
        System.out.println("Pontuação Média: " + pontuacaoMedia);
    }
}
