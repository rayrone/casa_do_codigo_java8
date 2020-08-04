package capitulo2;

public class Usuario {

    private String nome;
    private int pontos;
    private boolean moderador;

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

    @Override
    public String toString() {
        return nome;
    }
}
