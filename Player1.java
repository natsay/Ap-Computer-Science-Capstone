import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;


public class Player1 extends JComponent 
{
    private static final int BOX_X = 270;
    private static final int BOX_Y = 5; 

    private static final int BOX_WIDTH = 25;

    private static final int BOX_HEIGHT = 25;

    

    private Rectangle player;

    private Rectangle enemey;

    private Rectangle goal; 

    private int windowHeight=900;
  
    private int windowWidth=600; 
    private int ranNum=0; 
    private int squareWidth=25; 
    private int squareHeight=25; 
    private int squareYLocation=- squareWidth; 
    private boolean numberCreated= false; 
    private int score; 


    public Player1()
    {  
        // sets dimensions of player and goal square to the static varibles
        player = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);   
        goal= new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);   

        this.setFocusable(true);
        this.addKeyListener(new KeyStrokeListener());
        //creates the KeyStrokeListener
        score=0; 
        //sets the score tobe zero
    }
    public void generateRandomNumber() 
    {

        Random ran = new Random();
        //creates Random object
        ranNum = ran.nextInt(windowWidth - squareWidth) + 30;
        //generates a random number
        numberCreated = true;
        //sets numberCreated to true
    }
    
    
    
    public void paintComponent(Graphics g)
    {  
        super.paintComponent(g);
        //draws player,sets color of player then fills the player with the set color
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(player);
        g2.setColor(new Color(175,238,238)); 
        g2.fill(player);
        
        //sets color of enemey to green,creates dimensions of enemey, then fills the enemey with the set color
        g2.setColor(Color.green); 
        enemey=new Rectangle(ranNum, squareYLocation, squareWidth, squareHeight);
        g2.fill(enemey);
        
        
        //sets color of goal, draws goal, the fills goal with the set color
        g2.setColor(Color.blue); 
        g2.draw(goal); 
        g2.fill(goal); 
        //sets color of font, creates a new font object, then displays on the screen with certain pts
        g2.setColor(Color.white);
        Font font= new Font("Sans-Serif", Font.BOLD, 30);
        g2.setFont(font);
        g2.drawString(score+ "",30,30); 
        
        if (!numberCreated) 
        {
            generateRandomNumber();
            //creates a random number
        }
       
        if (squareYLocation <= windowHeight) 
        {
            squareYLocation++;
            //resets the x and y position to a new postition 

        } 
        else 
        {
            numberCreated = false;
            squareYLocation = -squareHeight;
        }

        if(player.intersects(goal))
        {
            //if the player reaches the goal it will reset to orginal position and add 10 to the score
            this.movePlayerTo(280,530);
            score += 10;
        }
        
        if(player.intersects(enemey))
        {
            //if the player hits the enemey then it will reset to the orginal postition and deduct 10pts
            
            this.movePlayerTo(280,530);
            score -= 10;
        }

        repaint();
        
        
        

    }

    /**
    Moves the rectangle to the given location.
    @param x the x-position of the new location
    @param y the y-position of the new location
     */
    public void movePlayerTo(int x, int y)
    {
        //moves player to set location
        player.setLocation(x, y);
        repaint();      
    }

    /**
    Moves the rectangle by a given amount. 
    @param dx the amount to move in the x-direction 
    @param dy the amount to move in the y-direction 
     */
    public void movePlayerBy(int dx, int dy)
    {
        //moves player by certain amount in a direction 
        player.translate(dx, dy);
        repaint();      
    }


    class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent event) 
        {
            String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
            if (key.equals("DOWN"))
            {
                //use keys to move down
                movePlayerBy(0, 10);            
            }
            else if (key.equals("UP"))
            {
                movePlayerBy(0, -10);
                // use keys to move up
            }
            else if (key.equals("LEFT"))
            {
                movePlayerBy(-10, 0);  
                //use keys to move left
            }
            else if (key.equals("RIGHT"))
            {
                movePlayerBy(10, 0);  
                //use keys to move right
            }
        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}



