package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Forkjoin extends RecursiveAction {
    private int[] array;

    public Forkjoin(int[] array) {
        this.array = array;
    }

    @Override
    protected void compute() {
        //condicion de parp
        if (array.length <= 1) {
            return;
        }
        //repartir arreglos
        int mid = array.length / 2;
        int[] izquierda = Arrays.copyOfRange(array, 0, mid);
        int[] derecha = Arrays.copyOfRange(array, mid, array.length);

        Forkjoin izquierdaTask = new Forkjoin(izquierda);
        Forkjoin derechaTask = new Forkjoin(derecha);

        invokeAll(izquierdaTask, derechaTask);
        //hilos que se ejecutan
        izquierdaTask.join();
        derechaTask.join();
        //acomodo
        merge(izquierda, derecha, array);
    }

    //metodo merge

    private void merge(int[] izquierda, int[] derecha, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                result[k++] = izquierda[i++];
            } else {
                result[k++] = derecha[j++];
            }
        }

        while (i < izquierda.length) {
            result[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            result[k++] = derecha[j++];
        }
    }

}
