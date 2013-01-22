import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUps extends Actor
{
    /**
     * Act - do whatever the PowerUps wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor wallcheck = getOneObjectAtOffset(0, 0, Wall.class);
        
        Helicopter helicopter = new Helicopter();
        
        if (wallcheck != null) {
            getWorld().removeObject(this);
        }
    }    
}
