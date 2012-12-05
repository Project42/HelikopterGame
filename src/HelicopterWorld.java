import greenfoot.*;
import java.util.List;
// --> Score word toegekend met  counter.add(20); <--
public class HelicopterWorld extends World {
    private Helicopter helicopter;
    private Counter scoreCounter;
    public HelicopterWorld() {
        super(640, 480, 1, false);
        helicopter = new Helicopter();
        addObject(helicopter, 320, 240);
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 20);
    }
    
    @Override
    public void act() {
        for (Actor actor : (List<Actor>)getObjects(null)) {
            if (actor == helicopter) continue;
            if (helicopter.getX() != 320) {
                actor.setLocation(actor.getX() + 320 - helicopter.getX(), actor.getY());
            }
            if (helicopter.getY() != 240) {
                actor.setLocation(actor.getX(), actor.getY() + 240 - helicopter.getY());
            }
            
            if (actor == scoreCounter) continue;
            if (scoreCounter.getX() != 60) {
                actor.setLocation(actor.getX() + 60 - scoreCounter.getX(), actor.getY());
            }
            if (scoreCounter.getY() != 20) {
                actor.setLocation(actor.getX(), actor.getY() + 20 - scoreCounter.getY());
            }
        }
        helicopter.setLocation(320, 240);
        scoreCounter.setLocation(60, 20);
    }
}
