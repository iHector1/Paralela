package Santa;

public class Duendes extends Thread{
    
    exMutua exM;
    
    public Duendes(exMutua m) {
       exM = m;
    }
    
    public void run(){
        
        while(true) {

            try {

               exM.duendesAtorados();
                
                System.out.println("(" + exM.getDuendes() +") Duendes necesitan ayuda");

                if(exM.getDuendes() >= 3 && exM.getDisponibilidad() == true && exM.getRenos() < 9 && exM.getDisponibilidadDuendes()== true){
                    exM.setAyuda(true);
                    System.out.println("Santa ayudará a 3 duendes");
                    sleep(3000);
                    exM.setAyuda(false);
                    System.out.println("El grupo de duendes ha sido ayudado");
                    if(exM.getDuendes() < 3)
                        System.out.println("Santa va a dormir, ¡A mimir!");
                    exM.duendesLiberados();
                }
                
               sleep(2000);

            } catch (InterruptedException e) {

            }
        }
    }
}
