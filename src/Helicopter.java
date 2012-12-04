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

    public void increaseSpeed() {
        speed = 16;
    }

    public void decreaseSpeed() {
        speed = 8;
    }

    private void consumePowerUp() {
        PowerUp powerUp = (PowerUp)getOneIntersectingObject(PowerUp.class);
        if (powerUp != null) {
            powerUp.apply(this);
            powerUp.getWorld().removeObject(powerUp);
        }
    }
}
