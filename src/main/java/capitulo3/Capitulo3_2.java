package capitulo3;

public class Capitulo3_2 {

    public static void main(String[] args) {
//        exemplo1();
//        exemplo2();
        exemplo3();
    }

    private static void exemplo1() {
        Validador<String> validadorCEP = new Validador<String>() {
            public boolean valida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };
        System.out.println("CEP válido = " + validadorCEP.valida("04101-300"));
    }

    private static void exemplo2() {
        Validador<String> validadorCEP = valor -> {
            return valor.matches("[0-9]{5}-[0-9]{3}");
        };
        System.out.println("CEP válido = " + validadorCEP.valida("04101-300"));
    }

    private static void exemplo3() {
        Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
        System.out.println("CEP válido = " + validadorCEP.valida("04101-300"));
    }
}