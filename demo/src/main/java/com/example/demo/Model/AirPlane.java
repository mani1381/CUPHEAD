package com.example.demo.Model;

import com.example.demo.Controller.KeyEventHandler;
import com.example.demo.Model.Weapons.*;
import com.example.demo.Main;
import com.example.demo.View.*;
import javafx.stage.Stage;
import java.io.IOException;
public class AirPlane {
    public static final double speed = 5;
    private final Game game;
    private boolean canBeDied = false;
    private PlaneParentObject object;
    private int health = 10;

    private String gunType = "bullet";

    public AirPlane(Game game) {
        this.game = game;
    }

    public void move() {
        object.setY(object.getY() + (KeyEventHandler.getStatus("S", "Down") - KeyEventHandler.getStatus("W", "Up")) * AirPlane.speed);
        object.setY(Math.max(50, Math.min(object.getY(), object.getPane().getHeight() - object.getHeight())));
        object.setX(object.getX() + (KeyEventHandler.getStatus("D", "Right") - KeyEventHandler.getStatus("A", "Left")) * AirPlane.speed);
        object.setX(Math.max(0, Math.min(object.getX(), object.getPane().getWidth() - object.getWidth())));
    }

    public boolean getHit() throws IOException {
        if (canBeDied) return false;
        health--;
        if (health == 0) {
            Main.saveData.saveUsers(Main.database);
            Stage stage = (Stage) this.getObject().getScene().getWindow();
            stage.close();

        }
        canBeDied = true;
        return true;
    }
    public void switchGunType() {
        if (gunType.equals("bomb")) {
            gunType = "bullet";
        }
        else {
            gunType = "bomb";
        }
    }
    public boolean isOnBullet() {
        return gunType.equals("bullet");
    }
    public void killMiniBosses() {
        for (vulnerable vulnerable : game.getDamageable()) {
            if ((vulnerable instanceof MiniBoss))
            {
                MiniBoss miniBoss = (MiniBoss) vulnerable;
                if (object.intersects(miniBoss.getParentObject().getLayoutBounds())) {
                    miniBoss.dealDamage(miniBoss.getHealth());
                    try {
                        if (getHit()) object.blink();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (miniBoss.getHealth() <= 0) {
                        miniBoss.remove();
                        break;
                    }
                }
            }

        }
    }

    public void fire() {
        Weapon weapon;
        if (isOnBullet()) weapon = new Bullet(game);
        else weapon = new Bomb(game);
        new WeaponParentObject(object.getPane(), weapon);


    }
    public PlaneParentObject getObject() {
        return object;
    }

    public void setObject(PlaneParentObject object) {
        this.object = object;
    }

    public int getHealth() {
        return health;
    }

    public void setCanBeDied(boolean canBeDied) {
        this.canBeDied = canBeDied;
    }

}
