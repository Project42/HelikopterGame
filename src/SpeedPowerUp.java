import greenfoot.*;

public class SpeedPowerUp extends PowerUp {
    void apply(Helicopter helicopter) {
        helicopter.increaseSpeed();
    }

    void remove(Helicopter helicopter) {
        helicopter.decreaseSpeed();
    }
}
