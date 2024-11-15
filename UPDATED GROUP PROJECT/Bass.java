import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bass extends Enemy
{
    // Changed to animate method to stay upright
    private GreenfootImage[] img = new GreenfootImage[1];

    public Bass(MyWorld origin){
        super(origin);
        img[0] = new GreenfootImage("shark.png");
        
        setImage(img[0]);
        
        speed = 0.85;

    }
    
    public void act(){
        super.act();
        // takes dir from super class
        animate(this, img, img[0].getWidth(), img[0].getHeight(), 16, direction);
    }
    
    /* Bass has no other unique perks other then doing damage */
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
    
    public boolean checkForCollision(){
       return false; 
    }
}
