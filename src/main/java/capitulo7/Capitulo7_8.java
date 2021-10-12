package capitulo7;

import capitulo2.Usuario;

import java.util.*;

public class Capitulo7_8 {

    /* Optional */
    public static void main(String[] args) {
        //testeOptionalSemOrElse();
        //testeOptionalComOrElseEListaVazia();
        //testeOptionalComOrElseEListaPreenchida();
        //testeOptionalComOrElseThrow();
        //testeOptionalComIfPresent();
        //obterOUsuarioComMaiorNumeroDePontos();
        obterONomeDoUsuarioComMaiorNumeroDePontos();
    }

    private static void testeOptionalSemOrElse() {
        List<Usuario> usuarios = new ArrayList<>();
        OptionalDouble media = usuarios.stream().mapToInt(Usuario::getPontos).average();
        double pontuacaoMedia = media.getAsDouble();
        System.out.println(pontuacaoMedia);
    }

    private static void testeOptionalComOrElseEListaVazia() {
        List<Usuario> usuarios = new ArrayList<>();
        OptionalDouble media = usuarios.stream().mapToInt(Usuario::getPontos).average();
        double pontuacaoMedia = media.orElse(0.0);
        System.out.println(pontuacaoMedia);
    }

    private static void testeOptionalComOrElseEListaPreenchida() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        double pontuacaoMedia = usuarios.stream().mapToInt(Usuario::getPontos).average().orElse(0.0);
        System.out.println("Pontuação Média: " + pontuacaoMedia);
    }

    private static void testeOptionalComOrElseThrow() {
        List<Usuario> usuarios = new ArrayList<>();
        OptionalDouble media = usuarios.stream().mapToInt(Usuario::getPontos).average();
        double pontuacaoMedia = media.orElseThrow(IllegalArgumentException::new);
        System.out.println(pontuacaoMedia);
    }

    private static void testeOptionalComIfPresent() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        usuarios.stream().mapToInt(Usuario::getPontos).average().ifPresent(System.out::println);
    }

    private static void obterOUsuarioComMaiorNumeroDePontos() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Optional<Usuario> max = usuarios.stream().max(Comparator.comparingInt(Usuario::getPontos));
        max.ifPresent(System.out::println);
    }

    private static void obterONomeDoUsuarioComMaiorNumeroDePontos() {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Optional<String> maxNome = usuarios.stream()
                .max(Comparator.comparingInt(Usuario::getPontos))
                .map(Usuario::getNome);

        maxNome.ifPresent(System.out::println);
    }
}
