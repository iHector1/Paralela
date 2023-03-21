package org.example;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Calle{

    private boolean cochesDerecha = false;
    private  boolean cochesIzquierda = false;

    private int contadorCochesDerecha = 2;
    private int contadorCochesIzquierda = 2;

    public synchronized boolean isCochesDerecha() {
        return cochesDerecha;
    }

    public synchronized void setCochesDerecha(boolean cochesDerecha) {
        this.cochesDerecha = cochesDerecha;
    }

    public synchronized boolean isCochesIzquierda() {
        return cochesIzquierda;
    }

    public synchronized void setCochesIzquierda(boolean cochesIzquierda) {
        this.cochesIzquierda = cochesIzquierda;
    }

    public synchronized int getContadorCochesDerecha() {
        return contadorCochesDerecha;
    }

    public synchronized void setContadorCochesDerecha(int contadorCochesDerecha) {
        this.contadorCochesDerecha = contadorCochesDerecha;
    }

    public synchronized int getContadorCochesIzquierda() {
        return contadorCochesIzquierda;
    }

    public synchronized void setContadorCochesIzquierda(int contadorCochesIzquierda) {
        this.contadorCochesIzquierda = contadorCochesIzquierda;
    }

    public synchronized int preferencia(){
        Random r = new Random();
        int preferencia = r.nextInt(2)+1;

        notifyAll();
        return preferencia;
    }

    public synchronized void cochesPasadosIzquierda(){
        this.contadorCochesIzquierda--;
        if(contadorCochesIzquierda==0){
            this.cochesIzquierda=false;
            this.cochesDerecha=true;
        }
        Random r = new Random();
        if(r.nextInt(2)+1==1){
            this.insertarCocheDerecho();
            try {
                sleep(500);
            } catch (InterruptedException e) { }
        }
        notifyAll();
    }

    public synchronized void cochesPasadosDerecha(){
        this.contadorCochesDerecha--;
        if(this.contadorCochesDerecha==0){
            this.cochesDerecha=false;
            this.cochesIzquierda=true;
        }
        Random r = new Random();
        if(r.nextInt(2)+1==1){
            this.insertarCocheIzquierdo();
            try {
                sleep(500);
            } catch (InterruptedException e) { }
        }
        notifyAll();
    }
    public synchronized void insertarCocheDerecho(){
        Random r = new Random();
        this.contadorCochesDerecha+=r.nextInt(2)+1;
        System.out.println("++"+this.contadorCochesDerecha+" estan estacionados de lado derecho");
        notifyAll();
    }

    public synchronized void insertarCocheIzquierdo(){
        Random r = new Random();
        this.contadorCochesIzquierda+=r.nextInt(2)+1;
        System.out.println("**"+this.contadorCochesIzquierda+" estan estacionados de lado izquierdo");
        notifyAll();
    }
}
