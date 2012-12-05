import greenfoot.*;
import java.util.List;

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
            if (actor == scoreCounter) continue;
            actor.setLocation(actor.getX() + 320 - helicopter.getX(), actor.getY());
            actor.setLocation(actor.getX(), actor.getY() + 240 - helicopter.getY());
        }

        helicopter.setLocation(320, 240);
        scoreCounter.setLocation(60, 20);
    }
}
