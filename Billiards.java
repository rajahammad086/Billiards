//Raja Hammad Mehmood
// Main program for running Billiards game
import java.awt.*;

public class Billiards {

    public static void main ( String[] args ) {
        Paint.buildWindow("Billiards",0,0,800,600,Color.DARK_GRAY);


        PoolTable table = new PoolTable();

        PaintAnimator animator = new PaintAnimator(15);
        animator.animate(table);


        for ( ; true ; ) {


            int arrow = Paint.getArrow();
            table.handleKeys(arrow);



        }

    }

}
