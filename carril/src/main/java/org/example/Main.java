package org.example;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Calle calle = new Calle();

        Coches centro = new Coches(calle);
        CochesIzquierdos izquierdos=new CochesIzquierdos(calle);
        CochesDerecha derecha = new CochesDerecha(calle);

        centro.start();
        try {
            sleep(500);
        }catch (InterruptedException e){

        }
        izquierdos.start();
        derecha.start();
    }
}