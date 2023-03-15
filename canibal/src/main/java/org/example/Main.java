package org.example;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        int raciones = 20;
        int cantCanibales = 5;
        Canibal canibales[] = new Canibal[cantCanibales];

        Comida r = new Comida(raciones);
        Cocinero cocinero = new Cocinero(r);

        for(int i = 0; i < cantCanibales; i++){
            canibales[i] = new Canibal(r, i+1);
        }
        cocinero.start();
        for(int i = 0; i < cantCanibales; i++){
            canibales[i].start();
            try {
                sleep(500);
            } catch (InterruptedException e) { }

        }
    }
}