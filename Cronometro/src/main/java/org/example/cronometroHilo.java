package org.example;

public class cronometroHilo extends Thread {

    public void run() {
        int nuMin=2;
        int nuSeg=1;
        try {
            while (true){
                if(nuSeg==0){
                    nuMin--;
                    nuSeg=59;
                }else{
                    nuSeg--;
                }
                if(nuSeg<10){
                    System.out.println("00"+":0"+nuMin+":0"+nuSeg);
                }else{
                    System.out.println("00"+":0"+nuMin+":"+nuSeg);

                }
                sleep(200);
                if(nuMin==0 &&nuSeg==0){
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
