package Santa;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        exMutua mutex = new exMutua();
        Animacion anim = new Animacion(mutex);
        Santa santa = new Santa(mutex);
        Duendes duendes = new Duendes(mutex);
        Renos renos = new Renos(mutex);
        
        santa.start();
        duendes.start();
        renos.start();
        
    }
    
}