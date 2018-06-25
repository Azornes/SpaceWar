
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Meteoryty {
    
    private int x, y;
    private int srednica=50;
    private Image meteoryt_obraz;
    
    public Meteoryty(int x, int y)
    {
        this.x=x;
        this.y=y-srednica;
        
        try {
        	meteoryt_obraz= ImageIO.read(new File("meteoryt_obraz.png"));
        } catch (IOException ex) {}
    }
    
    public void update(Gra gr, Statek_kosmiczny statek_kosmiczny)
    {
        if(y>=gr.getHeight())
        {
            y= 0-srednica;
        }
        else
        {
            y++;
            y++;
            
        }
        sprKolizja(statek_kosmiczny);
    }
    
    public void sprKolizja(Statek_kosmiczny statek_kosmiczny)
    {
        int statek_kosmicznyX=statek_kosmiczny.getX();
        int statek_kosmicznyY=statek_kosmiczny.getY();
        int promienStatek_kosmiczny=statek_kosmiczny.getSrednica()/2;
        
        int a= statek_kosmicznyX-x;
        int b=statek_kosmicznyY-y;
        int sumaProm= promienStatek_kosmiczny+srednica/2;
        
        double c=Math.sqrt((double)(a*a)+(double)(b*b));
        if(c<sumaProm)
        {
            statek_kosmiczny.setX(300);
            statek_kosmiczny.setY(600);
        }
    }
    
    public void stop(Thread t){
        t.stop();
    }
    
    public void paint(Graphics g)
    {
//        g.fillOval(x, y, srednica, srednica);
        g.drawImage(meteoryt_obraz, x, y, null);
    }
    
    
    
    
}
