package org.example;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class merge {
    public  void holi(){
        System.out.println("holi");
    }
    public ArrayList<Integer> merge(ArrayList<Integer> lista){
        if(lista.size() <= 1){
            return  lista;
        }
        // Dividir la lista en dos sublistas
        int medio = lista.size() / 2;
        ArrayList<Integer> sublistaIzquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Integer> sublistaDerecha = new ArrayList<>(lista.subList(medio, lista.size()));

        // Ordenar cada sublista utilizando recursión
        sublistaIzquierda = merge(sublistaIzquierda);
        sublistaDerecha = merge(sublistaDerecha);

        // Combinar las sublistas ordenadas
        ArrayList<Integer> resultado = new ArrayList<>();
        int indiceIzquierda = 0;
        int indiceDerecha = 0;
        while (indiceIzquierda < sublistaIzquierda.size() && indiceDerecha < sublistaDerecha.size()) {
            int valorIzquierda = sublistaIzquierda.get(indiceIzquierda);
            int valorDerecha = sublistaDerecha.get(indiceDerecha);
            if (valorIzquierda <= valorDerecha) {
                resultado.add(valorIzquierda);
                indiceIzquierda++;
            } else {
                resultado.add(valorDerecha);
                indiceDerecha++;
            }
        }
        //se agregan los numeros de izquierda a derecha
        resultado.addAll(sublistaIzquierda.subList(indiceIzquierda, sublistaIzquierda.size()));
        resultado.addAll(sublistaDerecha.subList(indiceDerecha, sublistaDerecha.size()));

        return resultado;
    }

}
