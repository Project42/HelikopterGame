import greenfoot.*;

public class Helicopter extends Actor {
    private int speed;

    public Helicopter() {
        speed = 8;
    }

    public void act() {
        if (Greenfoot.isKeyDown("w")) move(0, -speed);
        if (Greenfoot.isKeyDown("s")) move(0, +speed);
        if (Greenfoot.isKeyDown("a")) move(-speed, 0);
        if (Greenfoot.isKeyDown("d")) move(+speed, 0);

        consumePowerUp();
    }

    private void move(int dx, int dy) {
        setLocation(getX() + dx, getY() + dy);
    }

    private void consumePowerUp() {
        Actor powerUp = getOneIntersectingObject(SpeedPowerUp.class);
        if (powerUp != null) {
            powerUp.getWorld().removeObject(powerUp);
            speed = 16;
        }
    }
}
