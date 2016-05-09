import java.awt.*;

public class AbstractGameState
{
    private GameView view;
    
    public AbstractGameState(GameView view)
    {
        this.view = view;
    }
    
    public GameView getView()
    {
        return this.view;
    }
    
    public void drawOn(Graphics g)
    {
    }
    
}


