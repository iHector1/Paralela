package Santa;

public class exMutua {

    private int renos = 0;
    private int duendes = 0;
    private boolean disponible = true;
    private boolean disponibleDuendes = true;
    private boolean viaje = false;
    private boolean ayuda = false;
    
    
    public synchronized void duendesAtorados() {
        duendes++;
        notifyAll();
   }
    
    public synchronized void duendesLiberados(){
        duendes-=3;
        notifyAll();
   }
    
    public synchronized void llegaReno(){
        while (disponible == false && disponibleDuendes == false) {
            try {
               wait();
            }
            catch (InterruptedException e) { 
            } 
        }
        renos++;

        notifyAll();
    }

    public synchronized void salirTaller(){
        viaje=true;
        notifyAll();
    }
    
    public synchronized void regresarTaller(){
        viaje=false;
        renos = 0;
        notifyAll();
    }
    
    public boolean getViaje(){
        return viaje;
    }
    
    public boolean getAyuda(){
        return ayuda;
    }
    
    public void setAyuda(boolean a){
        this.ayuda=a;
    }
    
    public int getDuendes(){
        return duendes;
    }
    
    public int getRenos(){
        return renos;
    }
    
    public boolean getDisponibilidad(){
        return disponible;
    }
    
    public boolean getDisponibilidadDuendes(){
        return disponibleDuendes;
    }
    
    public void setDisponibilidad(boolean d){
        this.disponible = d;
    }
    
    public void setDisponibilidadDuendes(boolean d){
        this.disponibleDuendes = d;
    }
    
}

