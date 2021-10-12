package capitulo3;

public class Capitulo3_3 {

    public static void main(String[] args) {
        final int numero = 5;
        new Thread(() -> System.out.println(numero)).start();
    }
}
