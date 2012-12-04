import greenfoot.*;

public class Helicopter extends Actor {
    public void act() {
        if (Greenfoot.isKeyDown("w")) move(0, -16);
        if (Greenfoot.isKeyDown("s")) move(0, +16);
        if (Greenfoot.isKeyDown("a")) move(-16, 0);
        if (Greenfoot.isKeyDown("d")) move(+16, 0);
    }

    private void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }
}
