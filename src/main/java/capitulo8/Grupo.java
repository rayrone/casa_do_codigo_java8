package capitulo8;

import capitulo2.Usuario;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Grupo {

    private Set<Usuario> usuarios = new HashSet<>();

    public void add(Usuario u){
        usuarios.add(u);
    }

    public Set<Usuario> getUsuarios() {
        return Collections.unmodifiableSet(usuarios);
    }
}
