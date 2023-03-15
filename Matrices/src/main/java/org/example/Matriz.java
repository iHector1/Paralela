package org.example;

public class Matriz extends Thread {  // Variables globales
    static int m[][] = new int[3][3];
    static int x = 0, y = 0;

    static Matriz Hilo1 = new Matriz();
    static Matriz Hilo2 = new Matriz();

    static Boolean bandera = false;

    public static void main(String[] args) {

        System.out.println("Matriz");


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = (int) (Math.random() * 10);
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }


        for (x = 0; x < 3; x++) {
            for (y = 0; y < 3; y++) {
                if (!bandera) {
                    Hilo1.run();
                    bandera = true;
                } else {
                    Hilo2.run();
                    bandera = false;
                }
            }
        }

        System.out.println("Resultado");


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public void run() {
        m[x][y] = m[x][y] * 2;
    }

}