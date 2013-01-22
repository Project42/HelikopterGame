import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RadiusPowerUp2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RadiusPowerUp extends PowerUps implements PowerUp
{
    public void apply(Helicopter helicopter) {
        helicopter.setRadius(10);
    }

    public void remove(Helicopter helicopter) {
        helicopter.setRadius(3);
    }  
}