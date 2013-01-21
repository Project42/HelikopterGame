import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class HelicopterWorld extends World {
    private Helicopter helicopter;
    private Counter scoreCounter;
    private MenuBar menuBar;
    private Background background;
    private Wall wall;
    private Direction direction;
    
    public HelicopterWorld() {
        super(80, 80, 10, false);
        
        for (int i = 1; i < 15; ++i) {
            Victim victim;
            int randomvictim = 0 + (int)(Math.random() * ((7 - 0) + 1));
            switch (randomvictim) {
                case 0: victim = new Victim1(); break;
                case 1: victim = new Victim2(); break;
                case 2: victim = new Victim3(); break;
                case 3: victim = new Victim4(); break;
                case 4: victim = new Victim5(); break;
                case 5: victim = new Victim6(); break;
                case 6: victim = new Victim7(); break;
                case 7: victim = new Victim8(); break;
                
                default:
                    // Will never happen.
                    assert false;
                    return;
            }
            int x = i * 50 + (-5 + Greenfoot.getRandomNumber(10));
            
            addObject(victim, x, 58);
            
            House house = new House();
            addObject(house, x, 65);
        }
        
        background = new Background();
        addObject(background, 40, 39);
        
        helicopter = new Helicopter();
        addObject(helicopter, 40, 35);
        
        direction = new Direction();
        addObject(direction, 20, 68);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 6, 74);
        
        menuBar = new MenuBar();
        addObject(menuBar, 39, 75);
        
        wall = new Wall();
        addObject(wall, -35, 40);
        
        setPaintOrder(Counter.class, Helicopter.class, Victim.class, MenuBar.class, House.class);
    }

    @Override
    public void act() {
        for (Actor actor : (List<Actor>)getObjects(null)) {
            if (actor == helicopter) continue;
            if (actor == scoreCounter) continue;
        
            actor.setLocation(actor.getX() + 40 - helicopter.getX(), actor.getY());
        }
        
        if (Math.random() < 0.008) {
            Actor powerUp;
            switch (Greenfoot.getRandomNumber(2)) {
                case 0: powerUp = new SpeedPowerUp(); break;
                case 1: powerUp = new RadiusPowerUp(); break;
                default:
                    // Will never happen.
                    assert false;
                    return;
            }
            addObject(powerUp, -50 + Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(40));
        }

        helicopter.setLocation(40, helicopter.getY());
        scoreCounter.setLocation(6, 74);
        menuBar.setLocation(39, 75);
        background.setLocation(40, 39);
        scoreCounter.add(1);
    }
}
