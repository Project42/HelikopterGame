import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpeedPowerUp extends PowerUps implements PowerUp
{
    public void apply(Helicopter helicopter) {
        helicopter.increaseSpeed();
    }

    public void remove(Helicopter helicopter) {
        helicopter.decreaseSpeed();
    }
}