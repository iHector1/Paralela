package org.example;

public class Cocinero extends Thread {
    private Comida comida;

    public Cocinero(Comida r) {
        this.comida = r;
    }

    public synchronized void run() {
        while(true) {
            if(comida.haciendolasPiernas() == false){
                if(comida.mostrarComida() == 0){
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) { }
                }
                else{
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) { }
                }

                comida.haciendoPierna();
                if(comida.mostrarComida() == 1)
                    System.out.println("Canibal cocinero hacer 1 pierna");
                else
                    System.out.println("Canibal cocinero hacer " + comida.mostrarComida() + " piernas");
            }

        }
    }
}
