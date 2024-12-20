import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @lumilk
 * @version 1.0.0
 */
public class Button extends Interface
{
    private GreenfootImage[] img;
    private String myName;
    
    private int animTimer = -1;
    private boolean isAnimated;
    
    //use this constructor for debugging
    public Button(String name){
        isAnimated = true;
        myName = name;
        
        //3 animation states
        img = new GreenfootImage[3];
        
        for(int i = 0; i < img.length; i++){
            img[i] = new GreenfootImage(200, 50);
        }
        img[0].setColor(Color.YELLOW);
        img[1].setColor(Color.GREEN);
        img[2].setColor(Color.RED);
        for(int i = 0; i < img.length; i++){
            img[i].fill();
        }
        
        setImage(img[0]);
    }
    public Button(String name, String[] images, boolean isAnimated , double scale){
        this.isAnimated = isAnimated;
        myName = name;
        
        img = new GreenfootImage[3];
        for(int i = 0; i < img.length; i++){
            img[i] = new GreenfootImage(images[i]);
            img[i].scale((int)(img[i].getWidth() * scale), (int)(img[i].getHeight() * scale));
        }
        
        setImage(img[0]);
    }
    //constructor supports Color class in an array use Color.COLOR to set a color
    public Button(String name, int width, int height, Color[] colors, boolean isAnimated){
        myName = name;
        
        this.isAnimated = isAnimated;
        
        img = new GreenfootImage[3];
        for(int i = 0; i < img.length; i++){
            img[i] = new GreenfootImage(width, height);
            img[i].setColor(colors[i]);
            img[i].fill();
        }
        
        setImage(img[0]);
    }
    
    public void act(){
        super.act();
        doAnimation();
    }    
    
    // Return true if mouse clicked
    public boolean checkClicked(){
        if(Greenfoot.mouseClicked(this)){
            return true;
        }
        else{             
            return false;
        }
    }
    
    // Hover animation - sets to another image and animate for click
    public void doAnimation(){
        
        // Ensure none out of bounds
        if(isAnimated && img.length == 3){
            // Count down timer
            if(animTimer > 0){
                animTimer--;
            }
            // Reset time to idle state
            else if(animTimer == 0){
                //reset animation
                animTimer = -1;
                setImage(img[1]);
            }
            
            // Hover animations with mouseinfo
            if (Greenfoot.mouseMoved(this)){
                setImage(img[1]);
            }
            if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
                setImage(img[0]);
            }
            
            // Click animation, reset after certain period with timer
            if(checkClicked()){
                animTimer = 15;
                setImage(img[2]);
            }
        }
        else{
            checkClicked();
        }
    }
    
    @Override
    protected boolean isUserInteracting() {
        return Greenfoot.mouseMoved(this);
    }
}
