package capitulo6;

import capitulo2.Usuario;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Capitulo6_5 {

    /* Referenciando Construtores */
    public static void main(String[] args) {

        Supplier<Usuario> criadorDeUsuarios = Usuario::new;
        Usuario rayrone = criadorDeUsuarios.get();
        System.out.println(rayrone);

        Function<String, Usuario> criadorDeUsuarios2 = Usuario::new;
        Usuario zirtany = criadorDeUsuarios2.apply("Zirtany");
        System.out.println(zirtany);

        BiFunction<String, Integer, Usuario> criadorDeUsuarios3 = Usuario::new;
        Usuario rayroneZirtany = criadorDeUsuarios3.apply("Rayrone Zirtany", 200);
        System.out.println(rayroneZirtany);
    }
}
