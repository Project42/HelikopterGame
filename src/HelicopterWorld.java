import greenfoot.*;
import java.util.List;

public class HelicopterWorld extends World {
    private Helicopter helicopter;
    private Counter scoreCounter;
    private MenuBar menuBar;
    private House house1;
    private House house2;
    private Background background;
    private SpeedPowerUp speed1;
    private Victim victim1;
    private Victim victim2;
    
    public HelicopterWorld() {
        super(80, 80, 10, false);
        
        victim1 = new Victim1();
        addObject(victim1, 72, 58);
        
        victim2 = new Victim2();
        addObject(victim2, 20, 58);
        
        background = new Background();
        addObject(background, 40, 39);
        
        helicopter = new Helicopter();
        addObject(helicopter, 40, 35);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 6, 74);
        
        menuBar = new MenuBar();
        addObject(menuBar, 39, 75);
        
        house1 = new House();
        addObject(house1, 20, 65);
        
        house2 = new House();
        addObject(house2, 75, 65);
        
        speed1 = new SpeedPowerUp();
        addObject(speed1, 20, 40);
          
        setPaintOrder(Counter.class, Helicopter.class, Victim.class, MenuBar.class, House.class);
    }

    @Override
    public void act() {
        for (Actor actor : (List<Actor>)getObjects(null)) {
            if (actor == helicopter) continue;
            if (actor == scoreCounter) continue;
        
            actor.setLocation(actor.getX() + 40 - helicopter.getX(), actor.getY());
        }

        helicopter.setLocation(40, helicopter.getY());
        scoreCounter.setLocation(6, 74);
        menuBar.setLocation(39, 75);
        background.setLocation(40, 39);
        scoreCounter.add(1);
    }
}
