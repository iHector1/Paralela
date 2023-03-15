package org.example;

public class CochesDerecha extends Thread {
    public Calle calle;

    public CochesDerecha(Calle calle){
        this.calle=calle;
    }

    public void run(){
        while(true){
            while (this.calle.isCochesDerecha() == true && this.calle.getContadorCochesDerecha()>0){
                this.calle.cochesPasadosDerecha();
                System.out.println("El choche que transita de Derecha a izquierda "+this.calle.getContadorCochesDerecha());
                try{
                    sleep(2500);
                }catch (InterruptedException e){

                }
                if(this.calle.isCochesDerecha()==false&& this.calle.getContadorCochesDerecha()<=0){
                    while(this.calle.isCochesDerecha()==false){
                        try {
                            sleep(500);
                            this.calle.insertarCocheDerecho();
                        }catch (InterruptedException e){

                        }
                    }
                }
            }
        }
    }
}
