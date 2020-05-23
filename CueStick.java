// Raja Hammad Mehmood
// Creating a class of Billiards Cue stick.
import java.awt.*;
public class CueStick {

    private double x_; // x coordinate of the tip
    private double y_; // y coordinate of the tip
    private double length_; // length of the cue
    private double angle_; // angle of the cue
    private Color color_; // color of the cuestick
    /**
     * A constructor for the Cue stick
    *@param1 is the x coordinate
    *@param2 is the y coordinate
    *@param3 is the length
    *@param4 is the angle
    **@param5 is the color
    */
    public CueStick(double x, double y, double length, double angle, Color color) {
        // initializing the instance variables accordingly
        x_=x;
        y_=y;
        length_=length;
        angle_=angle;
        color_=color;
    }

    /**
     *method for painting the cue stick
    */
    public void paint(Ball ball) {
        Paint.setColor(color_);
        double radian= Math.PI*(angle_/180);
        double x=ball.getX()-length_*(Math.cos(radian));
        double y=ball.getY()-length_*(Math.sin(radian));
        Paint.drawLine((int)x,(int)y,(int)ball.getX(),(int)ball.getY());
        Paint.fillRect((int)x -10,(int)y -5,10,10);

    }
    /**
     *method to move cuestick clockwise
    */
    public void clockwise() {
        angle_=angle_+5;
    }
    /**
     *method to move cuestick anti clockwise
    */
    public void antiClockwise() {
        angle_=angle_-5;
    }
    /**
     *method to increase length of the cue stick
    */
    public void increaseLength() {
        length_=length_+5;
    }
    /**
     *method to decrease length of the cue stick
    */
    public void decreaseLength() {
        length_=length_-5;
    }
    /**
     *method to place the cue stick
    */
    public void placeCueStick(Ball ball) {
        x_=(ball.getX()-ball.getRadius());
        y_=ball.getY();
        angle_=0;
        length_=15;
    }
    /**
     *method for striking the cueball
    */
    public void strikeBall(Ball ball) {
        double radian= Math.PI*(angle_/180);
        ball.setVelocity( (length_*(Math.cos(radian))), (length_*(Math.sin(radian))));
    }



}