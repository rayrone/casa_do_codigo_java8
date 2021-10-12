package capitulo8;

import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo8_7 {

    public static void main(String[] args) {

        /* Streams primitivos */

        IntStream s1 = IntStream.range(1, 11);
        System.out.println("Soma dos elementos do stream: " + s1.sum());

        IntStream s2 = IntStream.range(1, 11);
        System.out.println("Quantidade de elementos do stream: " + s2.count());

        System.out.print("Elementos do stream: ");
        IntStream s3 = IntStream.range(1, 11);
        s3.forEach(u -> System.out.print(u + " "));

        System.out.println("");

        System.out.print("Elementos do stream dobrados: ");
        IntStream s4 = IntStream.range(1, 11);
        s4.map(u -> u * 2).forEach(u -> System.out.print(u + " "));

        System.out.println("");

        /* Streams infinitos com autoboxing */

        Random random1 = new Random(22);
        Supplier<Integer> supplier = () -> random1.nextInt();
        Stream<Integer> stream1 = Stream.generate(supplier);

        /* Streams infinitos sem autoboxing */

        Random random2 = new Random(22);
        IntStream stream2 = IntStream.generate(() -> random2.nextInt());

        /* Operações de curto-circuito em stream infinitos - limit */

        Random random3 = new Random(0);
        //IntStream stream3 = IntStream.generate(() -> random3.nextInt());
        //List<Integer> list3 = stream3.limit(100)
        //.boxed()
        //.collect(Collectors.toList());

        List<Integer> list3 = IntStream
                .generate(() -> random3.nextInt())
                .limit(100)
                .boxed()
                .collect(Collectors.toList());

        // Exemplo de Supplier que mantém estado (sem lambda, pois dentro
        // de um lambda não pode declarar atributos).
        // Vamos gerar a sequência infinita de números de Fibonacci de maneira
        // lazy e imprimir seus 10 primeiros elementos:

        System.out.print("Os 10 primeiros números da sequência de Fibonacci são: ");

        IntStream.generate(new Fibonacci())
                .limit(10)
                .forEach(n -> System.out.print(n + " "));

        System.out.println("");

        /* Operações de curto-circuito em stream infinitos - findFirst */

        int maiorQue100 = IntStream
                .generate(new Fibonacci())
                .filter(f -> f > 100)
                .findFirst()
                .getAsInt();

        System.out.println("O primeiro elemento maior que 100: " + maiorQue100);

        /* Operações de curto-circuito em stream infinitos - matchers */

        boolean temPar = IntStream.generate(new Fibonacci()).allMatch(f -> f % 2 == 0);
        System.out.println("Todos os números da sequência de Fibonacci são pares? " + temPar);

        // Quando for necessário manter o estado de apenas uma variável, podemos usar o iterate
        // em vez do generate, que recebe um UnaryOperator.

        IntStream.iterate(0, x -> x + 1)
            .limit(10)
            .forEach(n -> System.out.print(n + " "));

        // API antigas modificadas para trabalhar com streams infinitos
        Random random4 = new Random(22);
        IntStream stream4 = random4.ints();

    }
}

