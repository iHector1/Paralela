package org.example;

public class CochesIzquierdos extends  Thread{
    Calle calle;

    public CochesIzquierdos(Calle carril){
        this.calle = carril;
    }

    @Override
    public void run() {
        while(true) {
            while(calle.isCochesIzquierda() == true && calle.getContadorCochesIzquierda() > 0){
                this.calle.cochesPasadosIzquierda();
                System.out.println("El choche que transita de Derecha a izquierda" + calle.getContadorCochesIzquierda());
                //anim.MoverCarro(true);
                try {
                    sleep(2500);
                } catch (InterruptedException e) { }
            }

            if(this.calle.isCochesIzquierda() == false && calle.getContadorCochesIzquierda() <= 0){
                while(this.calle.isCochesIzquierda()== false){
                    try {
                        this.calle.insertarCocheIzquierdo();
                        sleep(100);
                    } catch (InterruptedException e) { }
                }
            }
        }

    }
}
