/**
 * Handle the math calculations needed to determine if the ball hits 
 * a wall.
 *
 * @author Stina Bridgeman
 */

public class Bouncer {

    // constants used to indicate what has been hit
    public final static int NONE = 0, LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;


    /**
     * Determine which wall, if any, the ball has hit. Also shifts the ball's
     * position to the point of impact. Note that "top" and "bottom" refer to the
     * relative position on the screen - because lower y coordinates are higher up
     * on the screen, the top wall will have a smaller y coordinate than the
     * bottom wall.
     *
     * @param left
     *          x coordinate of the left wall (left < right)
     * @param right
     *          x coordinate of the right wall (left < right)
     * @param top
     *          y coordinate of the top wall (top < bottom)
     * @param bottom
     *          y coordinate of the bottom wall (top < bottom)
     * @param ball
     *          the ball
     * @return one of Bouncer.LEFT, Bouncer.RIGHT, Bouncer.TOP, Bouncer.BOTTOM
     *         indicating which wall has been hit, or Bouncer.NONE if no wall has
     *         been hit
     */

    public static int getWallHit ( int left, int right, int top, int bottom,
                                   Ball[] ball, int i ) {
        if ( left >= right ) {
            throw new IllegalArgumentException(
                "left wall must be left of the right wall: got "
                + left + " < " + right);
        }
        if ( top >= bottom ) {
            throw new IllegalArgumentException(
                "top wall must be above bottom wall: got "
                + top + " < " + bottom);
        }

        double ballx = ball[i].getX(), bally = ball[i].getY();
        double ballradius = ball[i].getRadius();
        double ballleft = ballx - ballradius, ballright = ballx + ballradius;
        double balltop = bally - ballradius, ballbottom = bally + ballradius;
        double xvel = ball[i].getXVelocity(), yvel = ball[i].getYVelocity();

        if ( ballleft <= left && xvel < 0 ) {
            ball[i].setPosition(left + ballradius,bally);
            return LEFT;
        }

        if ( ballright >= right && xvel > 0 ) {
            ball[i].setPosition(right - ballradius,bally);
            return RIGHT;
        }

        if ( balltop <= top && yvel < 0 ) {
            ball[i].setPosition(ballx,top + ballradius);
            return TOP;
        }

        if ( ballbottom >= bottom && yvel > 0 ) {
            ball[i].setPosition(ballx,bottom - ballradius);
            return BOTTOM;
        }

        return NONE;
    }

}
