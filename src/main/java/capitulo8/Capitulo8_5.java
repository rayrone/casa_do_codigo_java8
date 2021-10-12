package capitulo8;

import capitulo2.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public class Capitulo8_5 {

    /* Operações de redução */
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .average()
                .getAsDouble();
        System.out.println("Pontuação Média: " + pontuacaoMedia);

        int totalDePontos = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .sum();
        System.out.println("Total de Pontos: " + totalDePontos);

        long quantidadedDeUsuarios = usuarios.stream()
                .count();
        System.out.println("Quantidade de Usuário: " + quantidadedDeUsuarios);

        Optional<Usuario> max = usuarios.stream()
                .max(Comparator.comparingInt(Usuario::getPontos));
        Usuario usuarioComAMaximaPontuacao = max.get();
        System.out.println("Usuário com Pontuação Máxima: " + usuarioComAMaximaPontuacao);

        // Soma como operação de redução
        int valorInicial = 0;
        IntBinaryOperator operacao = (a, b) -> a + b;

        int total = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(valorInicial, operacao);

        int total2 = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, (a, b) -> a + b);

        int total3 = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(0, Integer::sum);

        // Multiplicacao de todos os pontos (operação de redução)

        int produto = usuarios.stream()
                .mapToInt(Usuario::getPontos)
                .reduce(1, (a, b) -> a * b);

        System.out.println("Multiplicação de todos os pontos: " + produto);

        // Soma sem usar map (para os casos onde a utilização do map é custosa)

        int total4 = usuarios.stream()
                .reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);
        System.out.println("Total de Pontos (sem redução): " + totalDePontos);
    }
}
