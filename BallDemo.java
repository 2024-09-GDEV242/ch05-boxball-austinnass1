import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Austin Nass
 * @version 10/30/2024
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> bounceList;
    private ArrayList<BoxBall> boxList;
    private BouncingBall bounceBall;
    private BoxBall boxBall;
    private int ground;

    /**
     * Creates a BallDemo object, makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
 
     * 
     This changes the method bounce in class BallDemo to let the user choose howmany balls should be bouncing.
     * 
     * Simulate n-number of bouncing balls
     * 
     * @parameter n the number of balls
     */
    public void bounce(int n)
    {
      bounceList = new ArrayList<BouncingBall>();
               
        myCanvas.setVisible(true);
                       
        // draw the ground
        myCanvas.drawLine(50, 400, 550, 400);
        
        //add balls to ArrayList
        Random randx = new Random();
        Random randy = new Random();
        
        for(int i = 0; i<n; i++){
            bounceBall = new BouncingBall(randx.nextInt(300), randy.nextInt(250), 20, Color.RED, 400, myCanvas);
            bounceList.add(bounceBall);
        }
        
        // draw them and make them bounce
        boolean finished = false;
        while (!finished) {
           finished = true;
           
           //draw the balls
           for(int i= 0; i<bounceList.size();i++){
               BouncingBall showBall = bounceList.get(i);
               showBall.draw();
               
               // move the ball
               if (showBall.getXPosition() < 550) {
                   showBall.move(); // bounce the ball
                   
                   // stop once ball when they reach the end of the screen
                   if (showBall.getXPosition() < 550) {
                       finished = false;
                   }
               }
           }
           myCanvas.wait(50);
        }                       
    }
           
    /**
     * Give the balls in boxBounce random colors.
     * 
     * Simulate n-number of bouncing balls
     * 
     * @parameter n the number of balls
     */
    public void boxBounce(int n){
        boxList = new ArrayList<BoxBall>();
               
        myCanvas.setVisible(true);
        
        // draw box
        myCanvas.drawLine(50, 416, 550, 416); //ground
        myCanvas.drawLine(50, 100, 550, 100); //roof
        myCanvas.drawLine(50, 100, 50, 416); //left wall
        myCanvas.drawLine(550, 100, 550, 416); //right wall
        
        //add balls to ArrayList
        Random randx = new Random();
        Random randy = new Random();
        Random randColor = new Random();
        for(int i = 0; i<n; i++){
            float r = randColor.nextFloat();
            float g = randColor.nextFloat();
            float b = randColor.nextFloat();
            Color randomColor = new Color(r,g,b);
            boxBall = new BoxBall(randx.nextInt(500), randy.nextInt(250), 16, randomColor, 400, 100, 550, 50, myCanvas);
            boxList.add(boxBall);
        }
        
         // draw them and make them bounce
        boolean finished = false;
        while (!finished) {
           //draw the balls
           for(int i= 0; i<boxList.size();i++){
               BoxBall showBall = boxList.get(i);
               showBall.draw();
               showBall.move();
               
           }
           myCanvas.wait(30);
        }     
    }
}
