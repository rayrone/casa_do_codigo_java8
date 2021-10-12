package capitulo3;

public class Capitulo3_0 {

    public static void main(String[] args) {
//        exemplo1();
//        exemplo2();
        exemplo3();
    }

    private static void exemplo1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10000; i++) {
                    System.out.println(i);
                }
            }
        };

        new Thread(r).start();
    }

    private static void exemplo2() {
        Runnable r = () -> {
            for (int i = 0; i <= 10000; i++) {
                System.out.println(i);
            }
        };

        new Thread(r).start();
    }

    private static void exemplo3() {
        new Thread(() -> {
            for (int i = 0; i <= 10000; i++) {
                System.out.println(i);
            }
        }).start();
    }
}
