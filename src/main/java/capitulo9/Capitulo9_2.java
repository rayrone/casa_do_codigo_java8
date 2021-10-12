package capitulo9;

import capitulo2.Usuario;

import java.util.*;
import java.util.stream.Collectors;

// Grouping By e Partition By
public class Capitulo9_2 {

    public static void main(String[] args) {

        /* Queremos um mapa em que a chave seja a pontuação do usuário e o valor seja
        uma lista de usuários que possuem aquela pontuação */
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);
        Usuario user4 = new Usuario("Sergio Lopes", 120);
        Usuario user5 = new Usuario("Adriano Almeida", 100);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        // Fazendo da maneira tradicional
        Map<Integer, List<Usuario>> pontuacao1 = new HashMap<>();

        for (Usuario u : usuarios) {
            if (!pontuacao1.containsKey(u.getPontos())) {
                pontuacao1.put(u.getPontos(), new ArrayList<>());
            }
            pontuacao1.get(u.getPontos()).add(u);
        }

        System.out.println(pontuacao1);

        // Fazendo com default methods da interface Map
        Map<Integer, List<Usuario>> pontuacao2 = new HashMap<>();

        for (Usuario u : usuarios) {
            pontuacao2.computeIfAbsent(u.getPontos(), user -> new ArrayList<>())
                    .add(u);
        }

        System.out.println(pontuacao2);

        // Fazendo com Collectors.groupingBy

        Map<Integer, List<Usuario>> pontuacao3 = usuarios.stream()
                .collect(Collectors.groupingBy(Usuario::getPontos));

        System.out.println(pontuacao3);

        /* Queremos separar os usuário moderadores dos que não são */
        Map<Boolean, List<Usuario>> moderadores = usuarios.stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador));

        System.out.println(moderadores);

        /* Queremos separar os usuário moderadores dos que não são - pegando apenas o nome */
        Map<Boolean, List<String>> nomesPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(
                        Usuario::isModerador, Collectors.mapping(Usuario::getNome,
                                Collectors.toList())));

        System.out.println(nomesPorTipo);

        /* Queremos particionar por moderação e ter como valor a soma dos pontos dos usuários */
        Map<Boolean, Integer> pontuacaoPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador,
                        Collectors.summingInt(Usuario::getPontos)));

        System.out.println(pontuacaoPorTipo);

        /* Queremos concatenar todos os nomes dos usuários */
        String nomes = usuarios.stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining(", "));

        System.out.println(nomes);

    }
}
