import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
/**
 * Write a description of class HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP extends Actor
{
    /**
     * Act - do whatever the HP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public HP() {  
        GreenfootImage img = new GreenfootImage(200, 200);     
        img.setColor(new Color(255,255,255));    
        Font font = img.getFont();      
 
        img.setFont(font);      
        img.drawString("Health: ", 5, 195);  
        setImage(img);      
    }   
}
