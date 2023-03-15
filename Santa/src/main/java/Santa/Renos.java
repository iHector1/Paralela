package Santa;

public class Renos extends Thread{
    
    exMutua exM;
    
    public Renos(exMutua m) {
       exM = m;
    }
    
    public void run(){
        while(true) {
            try {
                exM.llegaReno();
                System.out.println("[" + exM.getRenos() + "] Renos han llegado");
                
                if(exM.getRenos() >= 9){
                    while (exM.getDisponibilidadDuendes() == false) {
                        try {
                           wait();
                        }
                        catch (InterruptedException e) { 
                        } 
                    }
                    
                    System.out.println("Todos los renos llegaron");

                    //Santa y renos reparten juguetes
                    sleep(200);
                    exM.salirTaller();

                    //Santa regresa de repartir
                    sleep(10000);
                    exM.regresarTaller();
                }
                if(exM.getRenos() == 0){
                    System.out.println("Santa regreso de repartir, los renos irán a descansar");
                }
               sleep(1500);
            } catch (InterruptedException e) { }
        }
    }
}