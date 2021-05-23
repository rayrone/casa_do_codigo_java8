package capitulo9;

import capitulo2.Usuario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static capitulo8.GZFiles.lines;

// Coletores Gerando Mapas
public class Capitulo9_1 {

    public static void main(String[] args) throws IOException {

        // Quantidade de linhas por arquivo (sem collector) - abordagem funcional, porém ruim
        Map<Path, Long> linesPerFile = new HashMap<Path, Long>();

        Files.list(Paths.get("./src/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(p -> linesPerFile.put(p, lines(p).count()));

        System.out.println(linesPerFile);

        // Quantidade de linhas por arquivo (sem collector)
        Map<Path, Long> linesPerFile2 = Files.list(Paths.get("./src/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .collect(Collectors.toMap(p -> p, p -> lines(p).count()));

        System.out.println(linesPerFile2);

        Map<Path, Long> linesPerFile3 = Files.list(Paths.get("./src/capitulo8"))
                .filter(p -> p.toString().endsWith(".java"))
                .collect(Collectors.toMap(Function.identity(), p -> lines(p).count()));

        System.out.println(linesPerFile3);

        // Mapear todos os usuários utilizando o seu nome como chave

        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Map<String, Usuario> usuariosPorNome = usuarios.stream()
                .collect(Collectors.toMap(Usuario::getNome, Function.identity()));

        System.out.println(usuariosPorNome);

    }
}
