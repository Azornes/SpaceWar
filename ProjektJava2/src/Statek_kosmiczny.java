
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Statek_kosmiczny {
    
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSrednica() {
        return srednica;
    }

    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }
    int srednica=50;
    Image statek_kosmiczny1, statek_kosmiczny2, statek_kosmiczny3, statek_kosmiczny;

    public Statek_kosmiczny(int x, int y) {
       
            this.x=x;
            this.y=y;
         try {    
        	 statek_kosmiczny1=ImageIO.read(new File("statek_kosmiczny1.png"));
        	 statek_kosmiczny2=ImageIO.read(new File("statek_kosmiczny2.png"));
        	 statek_kosmiczny3=ImageIO.read(new File("statek_kosmiczny3.png"));  
        	 statek_kosmiczny=statek_kosmiczny1;
        } catch (IOException ex) {}
        
        
    }
    
    
    
    public void update(Gra gra)
    {
        if(x+srednica>=gra.getWidth())
        {
            x= gra.getWidth()-srednica;
        }
        else if(x<=0)
        {
            x=0;
        }
       
        if(y<0)
        {
            y=0;
        }
        else if(y+srednica>=gra.getHeight())
        {
            y=gra.getHeight()-srednica;
        }
        else
        {
            y++;
        }
        
    }
    
    public void paint(Graphics g )
    {
//        g.fillOval(x, y, srednica, srednica);
        g.drawImage(statek_kosmiczny, x, y, null);
        
    }

    void ruchLewo() {
        x-=8;  
        statek_kosmiczny=statek_kosmiczny2;
    }

    void ruchPrawo() {
        x+=8;
        statek_kosmiczny=statek_kosmiczny3;
    }

    void ruchGora() {
        y-=8;
        statek_kosmiczny=statek_kosmiczny1;
    }

    void ruchDol() {
        y+=8;
        statek_kosmiczny=statek_kosmiczny1;
    }

    void pozWyjsciowa() {
        statek_kosmiczny=statek_kosmiczny1;
    }
    
    
    
    
}
