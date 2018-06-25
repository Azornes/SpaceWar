
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;




public class Gra extends Applet implements Runnable, KeyListener
{
    private Image zdjecie;
    private Graphics grafika;
    private Statek_kosmiczny statek_kosmiczny;
    private Meteoryty []meteoryty=new Meteoryty[8];
    private Image tlo;
    

    @Override
    public void init() {
        setSize(500, 600);
        addKeyListener(this);
        try {
			tlo= ImageIO.read(new File("tlo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void start() {
        
    	statek_kosmiczny=new Statek_kosmiczny(100,100);
        for(int i=0; i<meteoryty.length;i++)
        {
            Random r= new Random();
            
            meteoryty[i]=new Meteoryty(r.nextInt(450),-(r.nextInt(600)));
        }
        
        Thread t= new Thread(this);
        t.start();
        
    }

    @Override
    public void update(Graphics g) {
        if(zdjecie==null)
        {
            zdjecie=createImage(this.getSize().width, this.getSize().height);
            grafika=zdjecie.getGraphics();
        }
        
        grafika.setColor(getBackground());
        grafika.fillRect(0, 0, getSize().width, getSize().height);
        grafika.setColor(getForeground());
        paint(grafika);
        
        g.drawImage(zdjecie, 0, 0, this);
        
    }

    @Override
    public void paint(Graphics g) {
    	g.drawImage(tlo, 0, 0, this);
    	statek_kosmiczny.paint(g);
         for(int i=0; i<meteoryty.length;i++)
        {
        meteoryty[i].paint(g);
        }
        
        
         
       
    }

    @Override
    public void run() {
        
        while(true){
        	statek_kosmiczny.update(this);
             for(int i=0; i<meteoryty.length;i++)
        {
            meteoryty[i].update(this, statek_kosmiczny );
        }
            
            
            
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {}
        }
    }
    
     @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
            	statek_kosmiczny.ruchLewo();
                break;
            case KeyEvent.VK_RIGHT:
            	statek_kosmiczny.ruchPrawo();
                break;
            case KeyEvent.VK_UP:
            	statek_kosmiczny.ruchGora();
                
                break;
            case KeyEvent.VK_DOWN:
            	statek_kosmiczny.ruchDol();
                break;    
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

   

    @Override
    public void keyReleased(KeyEvent e) {
        
    	statek_kosmiczny.pozWyjsciowa();
    }
    
    
    
}
