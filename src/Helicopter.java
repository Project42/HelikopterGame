import greenfoot.*;
import javax.swing.*;

public class Helicopter extends Actor {
    private int speed;
    private PowerUp powerUp;
    private int powerUpActsRemaining;
    public int RespawnTimer;
    protected GreenfootImage image1;
    protected GreenfootImage image2;

    public Helicopter() {
        speed = 1;
        image1 = new GreenfootImage("HELIrechts.png");
        image2 = new GreenfootImage("HELIlinks.png");
    }

    @Override
    public void act() {
        if (Greenfoot.isKeyDown("w")) move(0, -speed);
        if (Greenfoot.isKeyDown("s")) move(0, +speed);
        if (Greenfoot.isKeyDown("a")) {
            move(-speed, 0); 
            switchImageLeft();
        }
        if (Greenfoot.isKeyDown("d")) {
            move(+speed, 0); 
            switchImageRight();
        }
        
        if (atWorldEdge() == true)    
        {    
           resetLocation();
        }   
        
        if (--powerUpActsRemaining <= 0) {
            setPowerUp(null);
        }
        
        if (--RespawnTimer <= 0) {

        }
        
        Actor menubar = getOneObjectAtOffset(0, 1, MenuBar.class);
        if (menubar != null) {
            move(0, -1);
            if (powerUpActsRemaining > 0) {
                move(0, -1);
            }
        }
        
        Actor houselinks = getOneObjectAtOffset(1, 0, House.class);
        Actor houserechts = getOneObjectAtOffset(-2, 0, House.class);
        Actor houseboven = getOneObjectAtOffset(0, 1, House.class);
        
        if (houselinks != null && Greenfoot.isKeyDown("d")) {
            JOptionPane.showMessageDialog(null, "Boem");
            resetLocation();
        }
        
        if (houserechts != null && Greenfoot.isKeyDown("a")) {
            JOptionPane.showMessageDialog(null, "Boem");
            resetLocation();
        }
        
        if (houseboven != null && Greenfoot.isKeyDown("s")) {
            JOptionPane.showMessageDialog(null, "Boem");
            resetLocation();
        }

        consumePowerUp();
    }

    private void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }

    public void increaseSpeed() {
        speed = 2;
    }

    public void decreaseSpeed() {
        speed = 1;
    }

    private void consumePowerUp() {
        Actor newPowerUp = (Actor)getOneIntersectingObject(PowerUp.class);
        if (newPowerUp != null) {
            setPowerUp((PowerUp)newPowerUp);
            newPowerUp.getWorld().removeObject(newPowerUp);
        }
    }

    private void setPowerUp(PowerUp newPowerUp) {
        if (newPowerUp == powerUp) return;
        if (powerUp != null) powerUp.remove(this);
        if (newPowerUp != null) {
            powerUp = newPowerUp;
            powerUp.apply(this);
        }
        powerUpActsRemaining = 1000;
    }
    
    private void resetLocation() {
        setLocation(40, 35);
        RespawnTimer = 100;
    }
    
        protected void switchImageLeft()
    {
        setImage(image2);
    }

    protected void switchImageRight()
    {
        setImage(image1);
    }
    
    public boolean atWorldEdge() {   
        if (getY() == 0) {  
            return true;
        } 
        else {  
            return false;  
        }  
    }  
}
