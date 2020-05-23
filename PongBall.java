// Raja Hammad Mehmood
// Creating a class of Pong Ball.
import java.awt.*;
public class PongBall {

    private int x_; // x coordinate of the ball
    private int y_; // y coordinate
    private int radius_; // radius of the ball
    private int hvelocity_; // horizontal velocity
    private int vvelocity_; // vertical velocity
    private Color color_; // color of the ball
    /**
     * A constructor for the Pong Ball
    *@param1 is the x coordinate
    *@param2 is the y coordinate
    *@param3 is the radius
    *@param4 is the horizontal velocity
    *@param5 is the vertical velocity
    *@param6 is the color of the ball
    */
    public PongBall(int x, int y, int radius, int hvelocity, int vvelocity, Color color) {
        // initializing the instance variables accordingly
        x_=x;
        y_=y;
        radius_=radius;
        hvelocity_=hvelocity;
        vvelocity_=vvelocity;
        color_=color;
    }
    /**
     * getter method for the x coordinate of the ball
    *@return is the x coordinate
    */
    public int getX() {
        return x_;
    }
    /**
     * getter method for the y coordinate of the ball
    *@return is the y coordinate
    */

    public int getY() {
        return y_;
    }
    /**
     * getter method for the radius of the ball
    *@return is the radius of the ball
    */
    public int getRadius() {
        return radius_;
    }
    /**
     * getter method for the horizontal velocity of the ball
    *@return is the horizontal velocity
    */
    public int getXVelocity() {
        return hvelocity_;
    }
    /**
     * getter method for the vertical velocity of the ball
    *@return is the vertical velocity
    */
    public int getYVelocity() {
        return vvelocity_;
    }
    /**
     *takes new x and y coordinates as parameters, and which sets the ball's position accordingly.
    */
    public void setPosition(int x, int y) {
        y_=y;
        x_=x;
    }
    /**
     *method for updating the ball's position.
    */
    public void move (){
        x_=x_+hvelocity_;
        y_=y_+vvelocity_;
    }
    
    /**
     *method for updating the ball's horizontal velocity in response to a bounce off of a vertical  wall, respectively.
    */
    public void bounceX (){
        hvelocity_=hvelocity_*-1;
    }
    
     /**
     *method for updating the ball's vertical velocity in response to a bounce off of a horizontal wall, respectively.
    */
    public void bounceY (){
        vvelocity_=vvelocity_*-1;
    }
    
    
    /**
     *method for painting the ball from the given color.
    */
    public void paint() {
        Paint.setColor(color_);
        Paint.fillOval(x_,y_,radius_,radius_);
    }

}