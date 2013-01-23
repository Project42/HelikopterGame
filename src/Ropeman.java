import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Ropeman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ropeman extends Actor
{
    /**
     * Act - do whatever the Ropeman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int radius;
    
    public Ropeman() {
        radius = 5;
    }
    
    public void act() 
    {
        List<Actor> victims = getObjectsInRange(radius, Victim.class);
        for (Actor victim : victims) {
            // TODO: Play sound.
            HelicopterWorld world = (HelicopterWorld)getWorld();
            world.addScore(50);
            world.removeObject(victim);
        }
    }    
    
    public void setRadius(int r) {
        if (r <= 0) r = 1;
        radius = r;
    }
    
    public int getRadius() {
        return radius;
    }
    
}
