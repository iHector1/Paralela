package org.example;

public class Main {
    public static void main(String[] args) {
        animalHilo a1=new animalHilo("Leon",60);
        animalHilo a2=new animalHilo("gallina",20);
        animalHilo a3=new animalHilo("cuyo",10);
        a1.start();
        a2.start();
        a3.start();
    }
}