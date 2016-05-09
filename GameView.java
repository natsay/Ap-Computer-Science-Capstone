
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class GameView extends JComponent
{
    private AbstractGameState state;
    public GameView()
    {
        this.setFocusable(true);
        this.transferFocus();
    }
    
    public void setState(AbstractGameState state)
    {
        this.state = state;
        this.repaint();
    }

    public void paintComponent(Graphics g)
    {
        state.drawOn(g);
    }

}