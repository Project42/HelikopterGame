import greenfoot.*;

public class SpeedPowerUp extends Actor implements PowerUp {
    public void apply(Helicopter helicopter) {
        helicopter.increaseSpeed();
    }

    public void remove(Helicopter helicopter) {
        helicopter.decreaseSpeed();
    }
}
