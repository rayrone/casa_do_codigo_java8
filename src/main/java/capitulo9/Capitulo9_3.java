package capitulo9;

import capitulo2.Usuario;

import java.util.Comparator;
import java.util.List;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static capitulo8.GeraUsuarios.gerarListaEnormeDeUsuarios;

// Executando o pipeline em paralelo
public class Capitulo9_3 {

    public static void main(String[] args) {

        LongPredicate primePredicate = x -> {
            if (x == 0 || x == 1) return false;
            if (x == 2) return true;
            return LongStream.range(2, x).noneMatch(i -> x % i == 0);
        };

        long inicio = System.currentTimeMillis();

        //filtrarOrdenados();
        //somarFiltrados();
        //contarPrimosDeFormaSequencial(primePredicate);
        contarPrimosDeFormaParalelamente(primePredicate);

        long fim = System.currentTimeMillis();
        System.out.println("Tempo (ms) para executar: " + (fim - inicio));
    }

    private static void filtrarOrdenados() {

        List<Usuario> usuarios = gerarListaEnormeDeUsuarios();

        List<Usuario> filtradosOrdenados = usuarios.parallelStream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());
    }

    private static void somarFiltrados() {

        long sum = LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();

        System.out.println("Soma dos números pares: " + sum);
    }

    private static void contarPrimosDeFormaSequencial(LongPredicate primePredicate) {

        long count = LongStream.range(0, 100_001)
                .sequential()
                .filter(primePredicate)
                .count();

        System.out.println("Quantidade de número primos: " + count);
    }

    private static void contarPrimosDeFormaParalelamente(LongPredicate primePredicate) {

        long count = LongStream.range(0, 100_001)
                .parallel()
                .filter(primePredicate)
                .count();

        System.out.println("Quantidade de número primos: " + count);
    }
}
