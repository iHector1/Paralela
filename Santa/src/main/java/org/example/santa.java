package org.example;

public class santa extends Thread {
    central central;

    public santa(central central) {
        this.central = central;
    }

    public void run(){
        while (true){
            if(this.central.getRenos()<9){
                this.central.setLibre(true);
            }
            if(this.central.getRenos()>=9){
                this.central.setLibre(false);
            }
            if(this.central.getDuendes()>=3 && this.central.isLibre()==true && this.central.isDisponibilidadDuendes()==true){
                this.central.setDisponibilidadDuendes(false);
            }
            if(this.central.getDuendes()<3 && this.central.isDisponibilidadDuendes()==false){
                this.central.setDisponibilidadDuendes(true);

            }
        }
    }
}
