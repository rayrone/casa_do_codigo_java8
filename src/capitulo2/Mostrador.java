package capitulo2;

import java.util.function.Consumer;

class Mostrador implements Consumer<Usuario> {
    @Override
    public void accept(Usuario usuario) {
        System.out.println(usuario.getNome());
    }
}