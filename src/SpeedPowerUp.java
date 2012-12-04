import greenfoot.*;

public class SpeedPowerUp extends PowerUp {
    @Override
    void apply(Helicopter helicopter) {
        helicopter.increaseSpeed();
    }

    @Override
    void remove(Helicopter helicopter) {
        helicopter.decreaseSpeed();
    }
}
