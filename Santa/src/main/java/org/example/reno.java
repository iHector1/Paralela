package org.example;

public class reno extends Thread{
    central central;

    public reno(central central){
        this.central=central;
    }

    public void run(){
        while(true){
            try{
                this.central.renosEspera();
                System.out.println("-- "+this.central.getRenos()+" rodolfos han llegado");
                /*verificacion de que hay suficientes renos*/
                if (this.central.getRenos()>=9){
                    /* si santa no anda ocupado*/
                    while(this.central.isDisponibilidadDuendes()==false){
                        try{
                            wait();
                        }catch (InterruptedException e){

                        }
                    }
                    /* le toca a santa manejar*/
                    System.out.println("Todos los rodolfos llegaron");
                    sleep(200);
                    this.central.salida();
                    /*santa regresa del reve*/
                    sleep(9000);
                    this.central.regresar();
                }
                if(this.central.getRenos()==0){
                    System.out.println("Santa ya regreso y los renos al corral");
                }
                sleep(1500);
            }catch (InterruptedException e){

            }
        }
    }
}
