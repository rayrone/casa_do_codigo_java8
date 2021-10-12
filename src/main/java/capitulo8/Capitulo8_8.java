package capitulo8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Capitulo8_8 {

    public static void main(String[] args) throws IOException {

        // Listando todos os arquivos de um diretório

        System.out.println("Listando todos os arquivos de um diretório");

        Files
                .list(Paths.get("./"))
                .forEach(System.out::println);

        System.out.println("\n");

        // Listando apenas os arquivos java de um diretório

        System.out.println("Listando apenas os arquivos java de um diretório");

        Files
                .list(Paths.get("./src/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(System.out::println);

        System.out.println("\n");

        // Acessando o conteúdo de todos os arquivos de um diretório

        System.out.println("Acessando o conteúdo de todos os arquivos de um diretório");

        Stream<Stream<String>> strings = Files
                .list(Paths.get("./src/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .map(p -> GZFiles.lines(p));
                //.forEach(System.out::println);
    }
}
