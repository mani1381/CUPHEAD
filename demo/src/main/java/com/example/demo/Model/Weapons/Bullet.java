package com.example.demo.Model.Weapons;

import javafx.scene.image.Image;
import com.example.demo.Model.Game;
import javafx.scene.paint.ImagePattern;
public class Bullet extends Weapon {

    public Bullet(Game game) {
        super(game);
    }

    @Override
    public int getImageHeight() {
        return 9;
    }


    @Override
    public int getDamage() {
        return 1;
    }

    public void move() {
        parentObject.setX(parentObject.getX() + speed);
    }

    @Override
    public int getImageWidth() {
        return 32;
    }

    @Override
    public ImagePattern getImage() {
        return Bullet.image;
    }

    public static double speed = 5;

    public static ImagePattern image = new ImagePattern(new Image(Bullet.class.getResource("/com/example/demo/PNG/game/bullet.png").toExternalForm()));



}
