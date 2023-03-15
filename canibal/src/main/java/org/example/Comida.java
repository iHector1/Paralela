package org.example;

public class Comida {
    private boolean cazo = true;
    private boolean reportado = false;
    private int trozos;
    private int piernasTotales;

    public Comida(int raciones){
        this.trozos = raciones;
        this.piernasTotales=raciones;
    }
//tomando piernas
    public synchronized int tomandoPierna() {
        while (cazo == false) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        trozos--;
        if(trozos > 0){

            cazo = true;
        }
        else {
            cazo = false;
        }
        notifyAll();
        return trozos;
    }
//llenando las piernas
    public synchronized void haciendoPierna() {
        while (cazo == true) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        trozos++;
        if(trozos >= piernasTotales){
            cazo = true;
        }
        notifyAll();
    }

    //retorna cuantos pedazos hay en el cazo
    public synchronized int mostrarComida() {
        notifyAll();
        return trozos;
    }

    //retorna si las piernas ya estan listas
    public synchronized boolean haciendolasPiernas() {
        notifyAll();
        return cazo;
    }

    //retorna si alguien reporto que no tiene piernas
    public synchronized boolean alerta() {
        notifyAll();
        return reportado;
    }
    //retorna si alguien esta tomando las piernas
    public synchronized void canibalAlerta() {
        reportado = true;
        notifyAll();
    }

    //quita el reporte de que no tiene piernas
    public synchronized void noAlerta() {
        reportado = false;
        notifyAll();
    }
}
