package capitulo7;

import capitulo2.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Capitulo7_1 {

    /* Tornando moderadores os 10 usuários com mais pontos */

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("João", 10);
        Usuario usuario2 = new Usuario("Maria", 52);
        Usuario usuario3 = new Usuario("Pedro", 42);
        Usuario usuario4 = new Usuario("Mariana", 80);
        Usuario usuario5 = new Usuario("Tamires", 75);
        Usuario usuario6 = new Usuario("Otávio", 68);
        Usuario usuario7 = new Usuario("Marcos", 98);
        Usuario usuario8 = new Usuario("Vitória", 100);
        Usuario usuario9 = new Usuario("Kelly", 89);
        Usuario usuario10 = new Usuario("Jorge", 91);
        Usuario usuario11 = new Usuario("Paulo", 36);
        Usuario usuario12 = new Usuario("Miguel", 48);
        Usuario usuario13 = new Usuario("Júlia", 79);
        Usuario usuario14 = new Usuario("Mara", 63);
        Usuario usuario15 = new Usuario("Mel", 39);

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5,
                usuario6, usuario7, usuario8, usuario9, usuario10, usuario11, usuario12, usuario13,
                usuario14, usuario15);

        usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
        usuarios.subList(0, 10).forEach(Usuario::tornarModerador);
    }
}
