package Santa;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Animacion  extends JFrame implements Runnable{

    private Thread hilo;
    int h,w,xsT=w/2,xrT=60;
    Graphics g;
    exMutua exM;

    private Image dbImage;
    private Graphics gAux;

    public Animacion(exMutua m){
        h=500;
        w=(int)(h*2);
        setTitle("Santa y su taller AAMR 19310170");
        setSize(w,h);
        setLayout(null);
        exM = m;
        
        g=this.getGraphics();

        hilo=new Thread(this);
        hilo.start();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void paint(Graphics g){

        dbImage = createImage(getWidth(),getHeight());
        gAux = dbImage.getGraphics();
        paintComponent(gAux);
        g.drawImage(dbImage,0,0,this);

    }

    public void paintComponent(Graphics g){

        int x,y=450,yS;
        super.paint(g);
        
        if(exM.getViaje()){
            xsT+=12;
            xrT+=12;
            yS=350;
        }else{
            xsT=w/2;
            xrT=60;
            yS=320;
        }
        if(exM.getAyuda()){
            yS=290;
        }
        
        Santa(g,xsT,yS);

        x=xrT;
        for(int i = 0; i< exM.getRenos(); i++){
            Reno(g,x,y);    
            x+=90;
        }
        
        if(!exM.getDisponibilidad()){
            Dormir(g,w/2,350);
        }
        
        x=60;
        for(int i = 0; i< exM.getDuendes(); i++){
            Duende(g,x,180);
            x+=90;
        }
    }

    public void Duende(Graphics g, int x, int y){

        Image imgDuende = null;

        try {
            imgDuende = ImageIO.read(new File("E:/android/Santa/src/main/java/images/duende.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imgDuende,x-100,y-150,200,160,this);

    }
    
    public void Santa(Graphics g, int x, int y){

        Image imgSanta = null;

        try {
            imgSanta = ImageIO.read(new File("E:/android/Santa/src/main/java/images/santa.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imgSanta,x,y-150,160,160,this);

    }
    
    public void Reno(Graphics g, int x, int y){

        Image imgSanta = null;

        try {
            imgSanta = ImageIO.read(new File("E:/android/Santa/src/main/java/images/reno.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(imgSanta,x-50,y-100,80,120,this);

    }

    public void Dormir(Graphics g,int x, int y){
        g.setColor(Color.BLACK);
        g.drawString("Z z z", x+45, y-100);
    }

    @Override
    public void run(){
        while(true){
            try{
                repaint();
                hilo.sleep(100);
            }catch(InterruptedException ex){
            }
        }
    }
     
}
