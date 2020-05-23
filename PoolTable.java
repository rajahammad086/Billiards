import java.awt.geom.Point2D;
import java.awt.*;                               
public class PoolTable {
    private Ball cueball_; // making the cueball
    private Ball [] balls_;// making the normal balls
    private Pocket[] pocket_; //making the pockets
    private CueStick cuestick_; // making the cuestick
    char character='z'; //character the user inputs

    public PoolTable() {
        cueball_= new Ball(200,300,10,0,0,Color.WHITE);
        balls_ = new Ball[8];
        balls_[0] = new Ball(600,300,10,0,0,Color.BLUE);
        balls_[1] = new Ball(621,325,10,0,0,Color.BLUE);
        balls_[2] = new Ball(644,348,10,0,0,Color.BLUE);
        balls_[3] = new Ball(623,280,10,0,0,Color.RED);
        balls_[4] = new Ball(644,260,10,0,0,Color.RED);
        balls_[5] = new Ball(645,285,10,0,0,Color.BLACK);
        balls_[6] = new Ball(646,306,10,0,0,Color.YELLOW);
        balls_[7] = new Ball(647,327,10,0,0,Color.RED);
        pocket_ = new Pocket[6];
        pocket_[0]=new Pocket(75,75,25,2,0);
        pocket_[1]=new Pocket(75,525,25,2,0);
        pocket_[2]=new Pocket(400,75,25,2,0);
        pocket_[3]=new Pocket(400,525,25,2,0);
        pocket_[4]=new Pocket(725,75,25,2,0);
        pocket_[5]=new Pocket(725,525,25,2,0);
        cuestick_=new CueStick(200-15,300,15,0,Color.BLACK);

    }
    /**
     *carries out the actions specified by a character or arrow the user presses
     */
    public void handleKeys(int arrow) {

        if(arrow == Paint.LEFT) {
            cuestick_.increaseLength();
        } else if(arrow == Paint.RIGHT) {
            cuestick_.decreaseLength();
        } else if(arrow == Paint.UP) {
            cuestick_.clockwise();
        } else if(arrow == Paint.DOWN) {
            cuestick_.antiClockwise();
        } else if (arrow == Paint.OTHER) {
             character = Paint.getChar();
            if (character== 'c') {
                cuestick_.placeCueStick(cueball_);
                cueball_.setVelocity(0,0);
                cuestick_.paint(cueball_);
            } else if (character==' ')  {
                cuestick_.strikeBall(cueball_);
             
            }

        }
    }



    public void doAnimateStep() {
       //moves the cue ball and other balls
       cueball_.move();

        for(int i=0; i<8; i++) {
            if (balls_[i]==null){
                
            }
            else{
         balls_[i].move();
            }
       }
       
        //handle collisions
        for(int count= 0; count<8; count++) {
            if (balls_[count]!=null){
            if (Point2D.distance(balls_[count].getX(),balls_[count].getY(),cueball_.getX(),cueball_.getY())<= 20 ) {
                double x=balls_[count].getXVelocity();
                double y=balls_[count].getYVelocity();
                balls_[count].setVelocity(cueball_.getXVelocity(),cueball_.getYVelocity()) ;
                cueball_.setVelocity(x,y);
            }
            }
        }
        
        for(int x=0; x<8; x++) {
            for(int z=0; z<8; z++) {
                if(z!=x && balls_[z]!=null && balls_[x]!=null) {
                    if (Point2D.distance(balls_[x].getX(),balls_[x].getY(),balls_[z].getX(),balls_[z].getY())<= 20 ) {
                        double h=balls_[z].getXVelocity();
                        double v=balls_[z].getYVelocity();
                        balls_[z].setVelocity(balls_[x].getXVelocity(),balls_[x].getYVelocity()) ;
                        balls_[x].setVelocity(h,v);
                    
                    }
                }
            }
        }
        

        //bouncing off the edges
           //for cueball
           if(Bouncer2.getWallHit(50,750,50,550,cueball_)==Bouncer.LEFT || Bouncer2.getWallHit(50,750,50,550,cueball_)==Bouncer.RIGHT) {
                cueball_.bounceX();
            } else if (Bouncer2.getWallHit(50,750,50,550,cueball_)==Bouncer.TOP || Bouncer2.getWallHit(50,750,50,550,cueball_)==Bouncer.BOTTOM) {
                cueball_.bounceY();
            }
           
           //for other balls
        for(int i=0; i<8; i++) {
            if (balls_[i]!=null){
            if(Bouncer.getWallHit(50,750,50,550,balls_,i)==Bouncer.LEFT || Bouncer.getWallHit(50,750,50,550,balls_,i)==Bouncer.RIGHT) {
                balls_[i].bounceX();
            } else if (Bouncer.getWallHit(50,750,50,550,balls_,i)==Bouncer.TOP || Bouncer.getWallHit(50,750,50,550,balls_,i)==Bouncer.BOTTOM) {
                balls_[i].bounceY();
            }
        }
        }
        //falling cue ball into the pocket
         for(int i=0; i<pocket_.length; i++) {
            if(Point2D.distance(cueball_.getX(),cueball_.getY(),pocket_[i].getX(),pocket_[i].getY()) <= pocket_[i].getRadius()-cueball_.getRadius()) {
               cueball_.setPosition(200,300);
               cueball_.setVelocity(0,0);
            }
        }
        
          //falling ball into the pocket 
         for(int i=0; i<balls_.length; i++) {
            for(int count=0;count<pocket_.length;count++){
                if(balls_[i]!=null && pocket_[count].isFull()!=true ){
            if(Point2D.distance(balls_[i].getX(),balls_[i].getY(),pocket_[count].getX(),pocket_[count].getY()) <=pocket_[count].getRadius()-balls_[i].getRadius()) {
               balls_[i]=null;
               pocket_[count].addBall();
            }
            }
            }
        } 

        //paint everything
        Paint.setColor(Color.GREEN);
        Paint.fillRect(50,50,700,500);
        if (character!=' '){
        cuestick_.paint(cueball_);
        }
        cueball_.paint();
        for(int i=0; i<8; i++) {
            if (balls_[i]!=null){
            balls_[i].paint();
            }
        }
        for(int i=0; i<6; i++) {
            if(pocket_[i].getNumOfBalls()==0){
            pocket_[i].paint(Color.BLACK);
            }
            else if(pocket_[i].getNumOfBalls()==1){
            pocket_[i].paint(Color.BLUE);
            }
            else if(pocket_[i].getNumOfBalls()==2){
            pocket_[i].paint(Color.RED);
            }
        }
       //checking for win
    int counter=0;
        for(int i=0; i<6; i++) {
           counter=counter+pocket_[i].getNumOfBalls();
           }
        
        if(counter==8){
            Paint.setColor(Color.RED);
            Paint.setFont("SansSerif", Font.BOLD, 24);
            Paint.drawString("You Win!",300,300); 
        }
        
    }
}