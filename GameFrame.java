import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameFrame extends JFrame
{
    private static final int FRAME_WIDTH = 600;
    //sets frame width
    private static final int FRAME_HEIGHT = 600;
    //sets frame height
    private Player1 scene;
    //intialize Player1 object

    class FrameWindowListener extends WindowAdapter
    {
        public void windowOpened(WindowEvent event)
        {
            scene.requestFocusInWindow();
        }
    }

    public GameFrame()
    {
  
        scene = new Player1();
        //creates a new Player1 object and assigns it to the varibale scene
        add(scene);
        //adds scene to the frame
       
        this.addWindowListener(new FrameWindowListener());
       
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //sets the size of the frame
        
        getContentPane().setBackground(Color.BLACK);
        //sets the background of the frame to black

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //allows to be able to close frame
        this.setVisible(true);
        //allows to see the frame
    }
}
        