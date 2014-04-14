import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 
public class BouncingBall extends JFrame implements MouseListener
{
    private JPanel canvas;
    private Ball ball;
    private int x = 0, y = 0;
     
    public BouncingBall()
    {
        setTitle("Bouncing Ball");
        Container contentPane = getContentPane();
        canvas = new JPanel();
         
        contentPane.add(canvas);
        setSize(300, 300);
        setVisible(true);
         
        canvas.addMouseListener(this);
}
  
    public void mousePressed(MouseEvent e) 
    {   
 
        ball = new Ball(canvas);
        Thread t = new Thread(ball);
        x = e.getX();
        y = e.getY(); 
        ball.setXCoord(x); 
        ball.setYCoord(y);
        ball.start();       
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
   
}
