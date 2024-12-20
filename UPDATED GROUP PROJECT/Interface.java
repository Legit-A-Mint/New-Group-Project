import greenfoot.*;  
/**
 * Interface
 * 
 * @lumilk
 * @1.0.0
 */
public abstract class Interface extends SuperSmoothMover{

    private int transparency = 255;

    //static creates a global timer for all subclasses
    private static int lastInteractionTime = 0;
    private final int MAX_IDLE_TIME = 1000;

    //inherited variables
    protected String name;
    protected boolean canFade;

    /**  delete later */protected int myX, myY;
    //every subclass must contain a check to see if the user interacts with object
    protected abstract boolean isUserInteracting();

    public void act() {
        if(canFade){
            if(isUserInteracting()){ 
                lastInteractionTime = 0;  //reset global timer
                resetTransparency();
            } 
            else{
                if(lastInteractionTime > MAX_IDLE_TIME){  // check shared idle time for all instances    
                    fadeTransparency();                  
                } 
                else{
                    resetTransparency();
                }
            }
            //continue to increase
            lastInteractionTime++;
        }
    }

    //handle transparency
    private void resetTransparency(){
        transparency = 255;
        //gets image from subclass
        getImage().setTransparency(transparency);
    }

    private void fadeTransparency(){
        //only decrease transparency if not already half
        if(transparency > 255/2){ 
            transparency -= 3;
            //gets image from subclass
            getImage().setTransparency(transparency);  //reapply transparency
        }
    }
}

