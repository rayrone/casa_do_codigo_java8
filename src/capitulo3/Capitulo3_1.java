package capitulo3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Capitulo3_1 {

    public static void main(String[] args) {
//        exemplo1();
//        exemplo2();
        exemplo3();
    }

    private static void exemplo1() {
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("evento do click acionado");
            }
        });
    }

    private static void exemplo2() {
        Button button = new Button();
        button.addActionListener((event) -> {
            System.out.println("evento do click acionado");
        });
    }

    private static void exemplo3() {
        Button button = new Button();
        button.addActionListener(event -> System.out.println("evento do click acionado"));
    }
}
