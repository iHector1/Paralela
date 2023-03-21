package org.example;

public class central {

    private int duendes = 0;
    private int renos = 0;
    private boolean libre = false;
    private boolean disponibilidadDuendes = false;
    private boolean viaje =false;
    private boolean ayuda =false;

    /* getters and setters*/
    public int getDuendes() {
        return duendes;
    }

    public void setDuendes(int duendes) {
        this.duendes = duendes;
    }

    public int getRenos() {
        return renos;
    }

    public void setRenos(int renos) {
        this.renos = renos;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public boolean isDisponibilidadDuendes() {
        return disponibilidadDuendes;
    }

    public void setDisponibilidadDuendes(boolean disponibilidadDuendes) {
        this.disponibilidadDuendes = disponibilidadDuendes;
    }

    public boolean isViaje() {
        return viaje;
    }

    public void setViaje(boolean viaje) {
        this.viaje = viaje;
    }

    public boolean isAyuda() {
        return ayuda;
    }

    public void setAyuda(boolean ayuda) {
        this.ayuda = ayuda;
    }

    /* Metodos */

    public synchronized void duendesEsperando(){
        this.duendes++;
        notifyAll();
    }


    public synchronized void duendesDespachados(){
        this.duendes-=3;
    }

    public synchronized void renosEspera(){
        while(this.libre == false && this.disponibilidadDuendes==false){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        this.renos++;
        notifyAll();
    }

    public synchronized void salida(){
        this.viaje=true;
        notifyAll();
    }
    public synchronized void regresar(){
        this.viaje=false;
        this.renos=0;
        notifyAll();
    }

}
