package org.example;

public class duende extends Thread{
    central central;

    public duende(central central){
        this.central=central;
    }

    public void run(){
        while (true){
            try{
               this.central.duendesEsperando();

               System.out.println(" * "+this.central.getDuendes()+" duendes siguen esperando");
               if(this.central.getDuendes() >= 3 && this.central.isLibre()==true && this.central.getRenos()<9
                       && this.central.isDisponibilidadDuendes()==true){
                   this.central.setAyuda(true);
                   System.out.println("Santa anda chambeando con 3 duendes");
                   sleep(3000);
                   this.central.setAyuda(false);
                   System.out.println("Se rifo el santa y ya termino con los duendes");
                   this.central.duendesDespachados();
               }
               sleep(2000);

            }catch (InterruptedException e){

            }
        }
    }

}
