package capitulo8;

import capitulo2.Usuario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Capitulo8_9 {

    public static void main(String[] args) throws IOException {

        // Acessando o conteúdo de todos os arquivos de um diretório - com flatmap
        // Com flatmap pode achatar um Stream de Streams

        Stream<String> strings = Files
                .list(Paths.get("./src/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .flatMap(p -> GZFiles.lines(p));
        strings.forEach(System.out::println);

        // Podemos encadear em vários níveis
        // O IntStream resultante possui todos os caracteres de todos os arquivos java do nosso diretório

        IntStream chars = Files
                    .list(Paths.get("./src/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .flatMap(p -> GZFiles.lines(p))
                .flatMapToInt((String s) -> s.chars());

        // Mais um exemplo de flatMap - coleção de coleção

        Grupo englishSpeakers = new Grupo();

        final Usuario rayrone = new Usuario("Rayrone");
        rayrone.adicionar(new Pedido(1));
        englishSpeakers.add(rayrone);

        final Usuario saori = new Usuario("Saori");
        saori.adicionar(new Pedido(2));
        englishSpeakers.add(saori);

        Grupo spanishSpeakers = new Grupo();

        final Usuario arlete = new Usuario("Arlete");
        arlete.adicionar(new Pedido(3));
        spanishSpeakers.add(arlete);

        final Usuario nami = new Usuario("Nami");
        nami.adicionar(new Pedido(4));
        spanishSpeakers.add(nami);

        List<Grupo> groups = Arrays.asList(englishSpeakers, spanishSpeakers);

        Stream<Usuario> usuariosStream = groups
                .stream()
                .flatMap(g -> g.getUsuarios().stream())
                .distinct();

        Stream<Pedido> pedidosStream = groups
                .stream()
                .flatMap(g -> g.getUsuarios().stream())
                .flatMap(u -> u.getPedidos().stream())
                .distinct();

        pedidosStream.forEach(System.out::println);
    }
}
