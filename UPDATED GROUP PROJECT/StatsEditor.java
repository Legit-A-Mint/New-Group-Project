import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A stats editor to allow the user to modify and customize that stats
 * as well as change the difficulty of the game mode
 * @Jonathan
 */
public class StatsEditor extends World
{
    String playerModel;
    
    // Intiate base Stats
    private int health = 100;
    private double speed = 1;
    private int difficulty = 1;
    private int coins = 0;
    
    // Multiplier for each difficulty
    private String[] diffName = {"EASY","MEDIUM","HARD","IMPOSSIBLE"};
    private String[] diffImg = {"easy.png", "normal.png", "insane.png", "impossible.png"};
    private double[] diffMulti = {0.3, 1, 1.3, 3};
    
    // Images
    private GreenfootImage temp;
    ImageDisplay healthTxt;
    ImageDisplay speedTxt;
    ImageDisplay diffTxt;
    ImageDisplay coinsTxt;

    // UI
    Button leftHealth;
    Button rightHealth;
    ImageDisplay heartImg;
    
    Button leftSpeed;
    Button rightSpeed;
    ImageDisplay speedImg;
    
    Button leftDifficulty;
    Button rightDifficulty;
    ImageDisplay diffDisplay;
    
    Button leftCoins;
    Button rightCoins;
    ImageDisplay coinsImg;
    
    Button start;
    
    public StatsEditor(String playerModel)
    {    
        super(1024, 576, 1, false);
        
        this.playerModel = playerModel;
        
        addObject(new Image("PixelOceanStart.png", 1024, 576), 512, 288);
        addObject(leftHealth = new Button("leftHealth", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5 , -1, false), getWidth()/4 - 200, 180);
        addObject(rightHealth = new Button("rightHealth", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5, 1, false), getWidth()/4 + 200, 180);
        
        addObject(leftSpeed = new Button("leftSpeed", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5, -1, false), getWidth()/4*3 - 200, 180);
        addObject(rightSpeed = new Button("rightSpeed", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5, 1, false), getWidth()/4*3 + 200, 180);
        
        addObject(leftDifficulty = new Button("leftDiff", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5, -1, false), getWidth()/4 - 200, 380);
        addObject(rightDifficulty = new Button("rightDiff", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5, 1, false), getWidth()/4 + 200, 380);
        
        addObject(leftCoins = new Button("leftCoins", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5, -1, false), getWidth()/4*3 - 200, 380);
        addObject(rightCoins = new Button("rightCoins", new String[]{"charArrow1.png","charArrow2.png","charArrow3.png"}, false, 1.5, 1, false), getWidth()/4*3 + 200, 380);
        
        addObject(healthTxt = new ImageDisplay(new GreenfootImage("Health: " + Integer.toString(health), 50, Color.WHITE, null)), getWidth()/4, 180);
        addObject(speedTxt = new ImageDisplay(new GreenfootImage("Speed: " + Double.toString(speed) + "x", 50, Color.WHITE, null)), getWidth()/4*3, 180);
        addObject(diffTxt = new ImageDisplay(new GreenfootImage(getDifficultyText(difficulty), 50, Color.WHITE, null)), getWidth()/4, 380);
        addObject(coinsTxt = new ImageDisplay(new GreenfootImage("Coins: " + Integer.toString(coins), 50, Color.WHITE, null)), getWidth()/4*3, 380);
        
        addObject(heartImg = new ImageDisplay(new GreenfootImage("pixel_Heart.png"), 80, 80), getWidth()/4, 100);
        addObject(speedImg = new ImageDisplay(new GreenfootImage("SpeedIcon.png"), 80, 80), getWidth()/4*3, 100);
        addObject(diffDisplay = new ImageDisplay(new GreenfootImage(getDifficultyImage(difficulty)),80,80), getWidth()/4, 300);
        addObject(coinsImg = new ImageDisplay(new GreenfootImage("coin.png"),80,80), getWidth()/4*3, 300);
        
        addObject(start = new Button("start",new String[]{"PlayButton.png","PlayButton.png","PlayButton.png"}, false, 0.5, 1, false), 512, 500);
    }
    
    public void act()
    {
        // Depending on which button is clicked, change the corresponding stat
        if (Greenfoot.mouseClicked(leftHealth)||Greenfoot.isKeyDown("left"))
        {
            if (health > 10)
                health -= 10;
            healthTxt.setImage(new GreenfootImage("Health: " + Integer.toString(health), 50, Color.WHITE, null));
        }
        if (Greenfoot.mouseClicked(rightHealth)||Greenfoot.isKeyDown("Right"))
        {
            if (health < 200)
                health += 10;
            healthTxt.setImage(new GreenfootImage("Health: " + Integer.toString(health), 50, Color.WHITE, null));
        }
        if (Greenfoot.mouseClicked(leftSpeed))
        {
            if (speed > 0)
                speed -= 0.1;
            speed = Math.round(speed*100);
            speed = speed/100;
            speedTxt.setImage(new GreenfootImage("Speed: " + Double.toString(speed) + "x", 50, Color.WHITE, null));
        }
        if (Greenfoot.mouseClicked(rightSpeed))
        {
            if (speed < 2)
                speed += 0.1;
            speed = Math.round(speed*100);
            speed = speed/100;
            speedTxt.setImage(new GreenfootImage("Speed: " + Double.toString(speed) + "x", 50, Color.WHITE, null));
        }
        if (Greenfoot.mouseClicked(leftDifficulty))
        {
            if (difficulty > 0)
                difficulty--;
            diffTxt.setImage(new GreenfootImage(getDifficultyText(difficulty), 50, Color.WHITE, null));
            diffDisplay.setImage(new GreenfootImage(getDifficultyImage(difficulty)));
            diffDisplay.scale(80,80);
        }
        if (Greenfoot.mouseClicked(rightDifficulty))
        {
            if (difficulty < 3)
                difficulty++;
            diffTxt.setImage(new GreenfootImage(getDifficultyText(difficulty), 50, Color.WHITE, null));
            diffDisplay.setImage(new GreenfootImage(getDifficultyImage(difficulty)));
            diffDisplay.scale(80,80);
        }
        if (Greenfoot.mouseClicked(leftCoins))
        {
            if (coins > 0)
                coins--;
            coinsTxt.setImage(new GreenfootImage("Coins: " + Integer.toString(coins), 50, Color.WHITE, null));
        }
        if (Greenfoot.mouseClicked(rightCoins))
        {
            coins++;
            coinsTxt.setImage(new GreenfootImage("Coins: " + Integer.toString(coins), 50, Color.WHITE, null));
        }
        if (Greenfoot.mouseClicked(start))
        {
            Greenfoot.setWorld(new SimulationWorld(playerModel, health, speed, diffMulti[difficulty], coins));
            SimulationWorld.ambientSound.playLoop();
        }
    }
    
    public String getDifficultyText(int difficulty)
    {
        return diffName[difficulty];
    }
    
    public String getDifficultyImage(int difficulty)
    {
        return diffImg[difficulty];
    }
}
