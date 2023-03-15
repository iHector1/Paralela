package org.example;

public class animalHilo extends Thread{
    int velocidad;
    String animal;

    animalHilo(String animal,int velocidad){
        this.velocidad=velocidad;
        this.animal=animal;
    }

    void recorrido(){
        int metros=100;
        while(metros>0.0){
            try{
                metros=metros-this.velocidad;
                sleep(500);
                if(metros<=0.0){
                    break;
                }else{
                    System.out.println("El animal "+this.animal+" le faltan: " + metros);
                }
            }catch(Exception e){
            }

        }
        System.out.println("El animal "+this.animal+" ha llegado a la meta");
    }


    public void run(){
        this.recorrido();
    }

}
