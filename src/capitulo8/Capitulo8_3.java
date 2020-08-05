package capitulo8;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Capitulo8_3 {

    public static void main(String[] args) {
        List<Usuario> usuarios = gerarListaEnormeDeUsuarios();
        encontrarUmUsuarioComMaisDe100PontosAbordagem1(usuarios);
        encontrarUmUsuarioComMaisDe100PontosAbordagem2(usuarios);
    }

    private static List<Usuario> gerarListaEnormeDeUsuarios() {
        int pontos[] = {150, 90, 80, 180};
        List<Usuario> usuarios = new ArrayList<>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 1000000; i++) {
            usuarios.add(new Usuario("Usuario " + i, pontos[i % 4]));
        }

        long fim = System.currentTimeMillis();

        System.out.println("Tempo (ms) para gerar a lista de usuários: " + (fim - inicio));

        return  usuarios;
    }

    private static void encontrarUmUsuarioComMaisDe100PontosAbordagem1(List<Usuario> usuarios) {
        long inicio = System.currentTimeMillis();

        Usuario maisDe100 = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .collect(Collectors.toList())
                .get(0);

        long fim = System.currentTimeMillis();

        System.out.println("Tempo (ms) para encontrar um usuário com a abordagem 1: " + (fim - inicio));
    }

    private static void encontrarUmUsuarioComMaisDe100PontosAbordagem2(List<Usuario> usuarios) {
        long inicio = System.currentTimeMillis();

        Optional<Usuario> usuarioOptional = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .findAny();

        long fim = System.currentTimeMillis();

        System.out.println("Tempo (ms) para encontrar um usuário com a abordagem 2: " + (fim - inicio));
    }
}
