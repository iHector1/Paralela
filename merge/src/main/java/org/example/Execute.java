package org.example;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class Execute extends RecursiveTask<int[]>  {
    private int[] array;
    private static final int THRESHOLD = 2;

    Execute(int[] array) {
        this.array = array;
    }

    public static int[] ordenar(int array[]) {

        if (array.length <= 1) {
            return array;
        }

        int mitad = array.length / 2;
        int izq[] = Arrays.copyOfRange(array, 0, mitad);
        int der[] = Arrays.copyOfRange(array, mitad, array.length);

        ordenar(izq);
        ordenar(der);
        comArray(array, izq, der);

        return array;
    }

    public static void comArray(int array[], int izq[], int der[]) {

        int i = 0;
        int j = 0;

        for (int k = 0; k < array.length; k++) {
            if (i >= izq.length) {
                array[k] = der[j];
                j++;
                continue;
            }
            if (j >= der.length) {
                array[k] = izq[i];
                i++;
                continue;
            }
            if (izq[i] < der[j]) {
                array[k] = izq[i];
                i++;
            } else {
                array[k] = der[j];
                j++;
            }
        }
    }

    @Override
    protected int[] compute() {
        if (array.length > THRESHOLD) {
            int mitad = array.length / 2;
            Execute firstSubtask = new Execute(Arrays.copyOfRange(array, 0, mitad));
            Execute secondSubtask = new Execute(Arrays.copyOfRange(array, mitad, array.length));

            secondSubtask.fork();

            comArray(array, firstSubtask.compute(), secondSubtask.join());
            return array;
        } else {
            return ordenar(array);
        }
    }
}
