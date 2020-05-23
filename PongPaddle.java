// Raja Hammad Mehmood
// Creating a class of Pong Paddle.
import java.awt.*;
public class PongPaddle {

    private int x_; // x coordinate
    private int y_; // y coordinate
    private int width_; // width of the paddle
    private int height_; // height of the paddle
    private Color color_; // color of the paddle
    /**
     * A constructor for the PongPaddle
    *@param1 is the x coordinate
    *@param2 is the y coordinate
    *@param3 is the width
    *@param4 is the height
    *@param5 is the color
    */
    public PongPaddle(int x, int y, int width, int height, Color color) {
        // initializing the instance variables accordingly
        x_=x;
        y_=y;
        width_=width;
        height_=height;
        color_=color;
    }
    /**
     * getter method for the top y coordinate of the paddle
    *@return is the top y coordinate
    */
    public int getTop() {
        return (y_-(height_/2));
    }
    /**
     * getter method for the bottom y coordinate of the paddle
    *@return is the bottom y coordinate
    */

    public int getBottom() {
        return (y_+(height_/2));
    }
    /**
     * getter method for the left x coordinate of the paddle
    *@return is the left x coordinate
    */
    public int getLeft() {
        return (x_-(width_/2));
    }
    /**
     * getter method for the right x coordinate of the paddle
    *@return is the right x coordinate
    */
    public int getRight() {
        return (x_+(width_/2));
    }
    /**
     *method for moving the paddle up.
    */
    public void moveUp(int pixels) {
        y_=y_-pixels;
    }
    /**
     *method for moving the paddle down.
    */
    public void moveDown(int pixels) {
        y_=y_+pixels;
    }
    /**
     *method for painting the rectangle from the given color.
    */
    public void paint() {
        Paint.setColor(color_);
        Paint.fillRect(getLeft(),getTop(),width_,height_);
    }

}