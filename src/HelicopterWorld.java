import greenfoot.*;
import java.util.List;

public class HelicopterWorld extends World {
    private Helicopter helicopter;

    public HelicopterWorld() {
        super(640, 480, 1);
        helicopter = new Helicopter();
        addObject(helicopter, 320, 240);
    }

    public void act() {
        for (Actor actor : (List<Actor>)getObjects(null)) {
            if (actor == helicopter) continue;
            if (helicopter.getX() != 320) {
                actor.setLocation(actor.getX() + 320 - helicopter.getX(), actor.getY());
            }
            if (helicopter.getY() != 240) {
                actor.setLocation(actor.getX(), actor.getY() + 240 - helicopter.getY());
            }
        }
        helicopter.setLocation(320, 240);
    }
}
