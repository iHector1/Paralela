package Santa;

public class Santa extends Thread{
    
    exMutua exM;
    
    public Santa(exMutua m) {
       exM = m;
    }
    
    public void run(){
        while(true) {
            //Si hay menos de 9 renos, santa seguira disponible
            if(exM.getRenos() < 9)
                exM.setDisponibilidad(true);
            //Si hay 9 renos, santa se irá a repartir
            if(exM.getRenos() >= 9)
                exM.setDisponibilidad(false);

            if(exM.getDuendes() >= 3 && exM.getDisponibilidad() == true && exM.getDisponibilidadDuendes() == true)
                exM.setDisponibilidadDuendes(false);

            if(exM.getDuendes() < 3 && exM.getDisponibilidadDuendes() == false)
                exM.setDisponibilidadDuendes(true);
        }
    }
}
