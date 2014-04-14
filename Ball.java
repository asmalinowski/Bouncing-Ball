import java.awt.*;
import javax.swing.*;

public class Ball extends Thread implements Runnable
{
   private JPanel box;
   private static final int XSIZE = 30;
   private static final int YSIZE = 30;
   private int x = 0;                          
   private int y = 0;                       
   private int dx = 2;                          
   private int dy = 2;                          
     
    public Ball(JPanel b) 
    {
        box = b; 
         
    }
     
    public void setXCoord(int XIn)
    {x=XIn;}
    public void setYCoord(int YIn)
    {y=YIn;}
 
 
public void draw() 
    {

        Graphics g = box.getGraphics();
        g.fillOval(x, y, XSIZE, YSIZE);
        g.dispose();
    }
     
public void move() 
    {
        Graphics g = box.getGraphics();
        g.clearRect(x, y, XSIZE, YSIZE);
        x += dx;
        y += dy;
        Dimension d = box.getSize();
 
        if (x < 0)
        { 
            x = 0; dx = -dx;
        }
 
        if (x + XSIZE >= d.width)
        { 
            x = d.width - XSIZE; dx = -dx; 
        }
if (y < 0)
        {
            y = 0; dy = -dy;
        }
 
        if (y + YSIZE >= d.height)
        { 
            y = d.height - YSIZE; dy = -dy; 
        }
         
        g.setColor(Color.blue);
        g.fillOval(x, y, XSIZE, YSIZE);
        g.dispose();
    }
     
public void bounce()
    {
        draw();
         
        for (int i = 1; i <= 2000; i++) 
        {
            move();
 
            try
            { 
                Thread.sleep(5); 
            }
            catch(InterruptedException e) 
            {
                System.err.println("InterruptedException" + e.getMessage());
            }
        }
    }
     
public void run()
    {
        try
        {
            for (int run=0; run < 5; run++) 
            {
             
            bounce ();
            Thread.sleep((long)(Math.random() * 500));
             
            }
        }
        catch (Exception e)
        {
            System.err.println(e.toString());
        }
    }
 
}
