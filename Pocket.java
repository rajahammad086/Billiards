// Raja Hammad Mehmood
// Creating a class of Billiards Pocket.
import java.awt.*;
public class Pocket {

    private double x_; // x coordinate of the pocket
    private double y_; // y coordinate of the pocket
    private double radius_; // radius of the pocket
    private int capacity_; // capacity of the pocket
    private int numOfBalls_; // number of balls in the pocket

    /**
     * A constructor for the Billiards Pocket
    *@param1 is the x coordinate
    *@param2 is the y coordinate
    *@param3 is the radius
    *@param4 is the capacity
    *@param5 is the number of balls in the pocket
    *@param6 is the color of the pocket
    */
    public Pocket(double x, double y, double radius, int capacity, int numOfBalls) {
        // initializing the instance variables accordingly
        x_=x;
        y_=y;
        radius_=radius;
        capacity_=capacity;
        numOfBalls_=numOfBalls;
    }
    /**
     * getter method for the x coordinate of the pocket
    *@return is the x coordinate
    */
    public double getX() {
        return x_;
    }
    /**
     * getter method for the y coordinate of the pocket
    *@return is the y coordinate
    */

    public double getY() {
        return y_;
    }
    /**
     * getter method for the radius of the pocket
    *@return is the radius of the pocket
    */
    public double getRadius() {
        return radius_;
    }
    /**
     * getter method for the number of balls in the pocket
    *@return is the number of balls
    */
    public int getNumOfBalls() {
        return numOfBalls_;
    }
    /**
     * method for whether the pocket is full or not.
    *@return is true if pocket is full and vice versa.
    */
    public boolean isFull() {
        if (numOfBalls_>=capacity_) {
            return true;
        } else {
            return false;
        }
    }


    /**
     *method for painting the ball from the given color.
    */
    public void paint(Color color) {
        Paint.setColor(color);
        Paint.fillOval((int)x_-(int)radius_,(int)y_-(int)radius_,(int)radius_*2,(int)radius_*2);
    }
    /**
     * method to add a ball in a pocket
    */
    public void addBall() {
        numOfBalls_++;
    }


}