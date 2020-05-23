// Raja Hammad Mehmood
// Creating a class of Billiards Ball.
import java.awt.*;
public class Ball {

    private double x_; // x coordinate of the ball
    private double y_; // y coordinate
    private double radius_; // radius of the ball
    private double hvelocity_; // horizontal velocity
    private double vvelocity_; // vertical velocity
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
    public Ball(double x, double y, double radius, double hvelocity, double vvelocity, Color color) {
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
    public double getX() {
        return x_;
    }
    /**
     * getter method for the y coordinate of the ball
    *@return is the y coordinate
    */

    public double getY() {
        return y_;
    }
    /**
     * getter method for the radius of the ball
    *@return is the radius of the ball
    */
    public double getRadius() {
        return radius_;
    }
    /**
     * getter method for the horizontal velocity of the ball
    *@return is the horizontal velocity
    */
    public double getXVelocity() {
        return hvelocity_;
    }
    /**
     * getter method for the vertical velocity of the ball
    *@return is the vertical velocity
    */
    public double getYVelocity() {
        return vvelocity_;
    }
    /**
     *takes new x and y coordinates as parameters, and which sets the ball's position accordingly.
    */
    public void setPosition(double x, double y) {
        System.out.println("I'm here position");
        y_=y;
        x_=x;
    }
    /**
     *takes new horizontal and vertical velocity as parameters, and which sets the ball's velocity accordingly.
    */
    public void setVelocity(double hvelocity, double vvelocity) {
        
        hvelocity_=hvelocity;
        vvelocity_=vvelocity;
    }
    /**
     *method for updating the ball's position.
    */
    public void move () {
       hvelocity_=hvelocity_*0.974;
        x_=x_+hvelocity_;
        vvelocity_=vvelocity_*0.974;
        y_=y_+vvelocity_;
    }

    /**
     *method for updating the ball's horizontal velocity in response to a bounce off of a vertical  wall, respectively.
    */
    public void bounceX () {
        hvelocity_=hvelocity_*-1;
    }

    /**
    *method for updating the ball's vertical velocity in response to a bounce off of a horizontal wall, respectively.
    */
    public void bounceY () {
        vvelocity_=vvelocity_*-1;
    }


    /**
     *method for painting the ball from the given color.
    */
    public void paint() {
        Paint.setColor(color_);
        Paint.fillOval((int)x_-(int)radius_,(int)y_-(int)radius_,(int)radius_*2,(int)radius_*2);
    }

}