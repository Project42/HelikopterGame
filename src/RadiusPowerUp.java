import greenfoot.*;

public class RadiusPowerUp extends Actor implements PowerUp {
    public void apply(Helicopter helicopter) {
        helicopter.setRadius(10);
    }

    public void remove(Helicopter helicopter) {
        helicopter.setRadius(3);
    }
}
