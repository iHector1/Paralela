package org.example;

public class Canibal extends Thread {
    private Comida pedazos;
    private int canibalN;


    public Canibal(Comida r, int n) {
        this.pedazos = r;
        this.canibalN = n;

    }

    public synchronized void run() {
        while(true) {
            if(pedazos.haciendolasPiernas() == false){
                if(pedazos.alerta() == false){
                    pedazos.canibalAlerta();

                    System.out.println("Canibal (" + this.canibalN + ") no tener pierna, Quieroooooooooo maaaass");

                    while (pedazos.haciendolasPiernas() == false) {
                        try {
                            sleep(500);
                        } catch (InterruptedException e) { }
                    }
                    System.out.println("Canibal (" + this.canibalN + ") tomar pierna. [Quedan " + pedazos.tomandoPierna() + " piernas en el cazo]");
                    pedazos.noAlerta();
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) { }
                }
                else{
                    System.out.println("Canibal (" + this.canibalN + ") tomar pierna. [Quedan " + pedazos.tomandoPierna() + " piernas en el cazo]");

                    try {
                        sleep(2000);
                    } catch (InterruptedException e) { }
                }
            }else{
                System.out.println("Canibal (" + this.canibalN + ") tomar pierna. [Quedan " + pedazos.tomandoPierna() + " piernas en el cazo]");

                try {
                    sleep(2000);
                } catch (InterruptedException e) { }
            }

        }
    }
}