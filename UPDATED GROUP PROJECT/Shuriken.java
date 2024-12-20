import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shuriken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuriken extends Projectile
{
    /**
     * Act - do whatever the Shuriken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private static final int PIERCE_CAP = 1;
    private int hitCount;
    
    private static final GreenfootSound fireSfx = new GreenfootSound("Shuriken.mp3");
    
    public Shuriken(){
        img = new GreenfootImage("Proj3.png");
        img.scale(23,23);
        setImage(img);
        
        speed = 4.4;
        damage = 1;
        attackSpeed = 35;
        lifeSpan = 100;
        hitCount = 0;
         
        
        playShurikenSound();
    }
    
    public void act()
    {
        hitSomething();
        super.act();
    }
    
    public void hitSomething(){
        if(getOneIntersectingObject(Enemy.class) != null){
            hitEnemy = (Enemy) getOneIntersectingObject(Enemy.class);
            hitEnemy.damageMe(damage);
            hitCount++;
            if(hitCount >= PIERCE_CAP){
                removeMe = true;
            }
            if(getOneIntersectingObject(CollisionHitbox.class) != null){
                speed = 0;
            }
        }
    }
    
    private void playShurikenSound() {
        fireSfx.play();
    }
}
