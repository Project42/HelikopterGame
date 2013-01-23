import greenfoot.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class HelicopterWorld extends World {
    private Helicopter helicopter;
    private Counter scoreCounter;
    private MenuBar menuBar;
    private Background background;
    private Wall wall;
    private Direction direction;
    private Water water;
    private HP hp;
    private Health health1;
    private Health health2;
    private Health health3;
    private Health2 health4;
    private Health2 health5;
    private Health2 health6;
    private int healthlost;
    private int healthlostrope;
    
    public HelicopterWorld() {
        super(80, 80, 10, false);

        for (int i = 1; i < 15; ++i) {
            Victim victim;
            int randomvictim = 0 + (int)(Math.random() * ((7 - 0) + 1));
            switch (randomvictim) {
                case 0: victim = new Victim1(); break;
                case 1: victim = new Victim2(); break;
                case 2: victim = new Victim3(); break;
                case 3: victim = new Victim4(); break;
                case 4: victim = new Victim5(); break;
                case 5: victim = new Victim6(); break;
                case 6: victim = new Victim7(); break;
                case 7: victim = new Victim8(); break;

                default:
                    // Will never happen.
                    assert false;
                    return;
            }
            int x = i * 50 + (-5 + Greenfoot.getRandomNumber(10));

            addObject(victim, x, 58);

            House house = new House();
            addObject(house, x, 65);
        }

        background = new Background();
        addObject(background, 40, 39);
        
        helicopter = new Helicopter();
        addObject(helicopter, 40, 35);

        direction = new Direction();
        addObject(direction, 20, 68);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 6, 73);

        menuBar = new MenuBar();
        addObject(menuBar, 39, 75);

        wall = new Wall();
        addObject(wall, -35, 40);

        water = new Water();
        addObject(water, 40, 70);
        
        hp = new HP();
        addObject(hp, 60, 64);
        
        health1 = new Health();
        addObject(health1, 60, 73);
        
        health2 = new Health();
        addObject(health2, 64, 73);
        
        health3 = new Health();
        addObject(health3, 68, 73);
        
        health4 = new Health2();
        addObject(health4, 60, 77);
        
        health5 = new Health2();
        addObject(health5, 64, 77);
        
        health6 = new Health2();
        addObject(health6, 68, 77);
        
        
        
        setPaintOrder(Counter.class, HP.class, Health2.class, Health.class, Helicopter.class, MenuBar.class, Wall.class, Water.class, Victim.class, MenuBar.class, House.class, SpeedPowerUp.class, RadiusPowerUp.class);
    }

    @Override
    public void act() {
        for (Actor actor : (List<Actor>)getObjects(null)) {
            if (actor == helicopter) continue;
            if (actor == scoreCounter) continue;

            actor.setLocation(actor.getX() + 40 - helicopter.getX(), actor.getY());
        }

        if (Math.random() < 0.003) {
            Actor powerUp;
            switch (Greenfoot.getRandomNumber(2)) {
                case 0: powerUp = new SpeedPowerUp(); break;
                case 1: powerUp = new RadiusPowerUp(); break;
                default:
                    // Will never happen.
                    assert false;
                    return;
            }
            addObject(powerUp, -50 + Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(40));
        }

        helicopter.setLocation(40, helicopter.getY());
        scoreCounter.setLocation(6, 73);
        menuBar.setLocation(39, 75);
        background.setLocation(40, 39);
        health1.setLocation(60, 73);
        health2.setLocation(64, 73);
        health3.setLocation(68, 73);
        health4.setLocation(60, 77);
        health5.setLocation(64, 77);
        health6.setLocation(68, 77);
        hp.setLocation(60,64);
    }
    
    public int getWaterLevel() {
        return water.getLevel();
    }
    
    public void addScore(int x) {
        scoreCounter.add(x);
    }
    
    public void lostLife() {
        healthlost ++;
        switch (healthlost) {
            case 1: removeObject(health1); break;
            case 2: removeObject(health2); break;
            case 3:
                removeObject(health3);
                gameOver();
                break;
        }
    }
    
    public void lostLifeRope() {
        healthlostrope ++;
        switch (healthlostrope) {
            case 1: removeObject(health4); break;
            case 2: removeObject(health5); break;
            case 3:
                removeObject(health6);
                gameOver();
                break;
        }
    }
    
    private void gameOver() {
        Greenfoot.setWorld(new GameOverWorld(Game.HELICOPTER_GAME, scoreCounter.getValue()));
    }
}
