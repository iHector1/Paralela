package org.example;

public class Main {
    public static void main(String[] args) {
        central central=new central();
        santa santa=new santa(central);
        duende duende=new duende(central);
        reno reno=new reno(central);

        santa.start();
        duende.start();
        reno.start();
    }
}