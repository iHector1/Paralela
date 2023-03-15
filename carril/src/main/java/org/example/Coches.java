package org.example;

import java.util.Random;

public class Coches extends Thread{
    Calle calle;
    public Coches(Calle calle){
        this.calle=calle;
    }

    public void run(){
        while(true){
            Random r = new Random();
            int tiempo = r.nextInt(4200-500)+500;
            int preferencia = this.calle.preferencia();
            if(preferencia == 1){
                if(this.calle.isCochesDerecha()==false){
                    this.calle.setCochesIzquierda(true);

                }else if(preferencia==2){
                    if(this.calle.isCochesIzquierda()==false){
                        this.calle.setCochesDerecha(true);
                    }
                }

            }
            try {
                sleep(tiempo);
            }catch (InterruptedException e){

            }
        }
    }
}
