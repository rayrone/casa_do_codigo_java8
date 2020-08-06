package capitulo2;

import capitulo8.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario() {
        nome = "";
        pontos = 0;
        moderador = false;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void tornarModerador() {
        this.moderador = true;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void adicionar(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    @Override
    public String toString() {
        return nome;
    }
}
