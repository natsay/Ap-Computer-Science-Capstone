import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;


public class GameFrame extends JFrame
{
    private static final int FRAME_WIDTH=600; 
    private static final int FRAME_HEIGHT=600; 
    
    private static GameFrame frame; 
    
    public GameFrame() 
    {
        this.setTitle("Comp Sci Capstone"); 
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true); 
        getContentPane().setBackground(Color.BLACK); 
    }
    public static void main(String[] args) 
    {
        frame= new GameFrame(); 
    }
}
