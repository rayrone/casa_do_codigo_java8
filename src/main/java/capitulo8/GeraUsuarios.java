package capitulo8;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GeraUsuarios {

    public static List<Usuario> gerarListaEnormeDeUsuarios() {
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
}
