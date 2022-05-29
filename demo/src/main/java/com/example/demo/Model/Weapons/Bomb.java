package com.example.demo.Model.Weapons;

import com.example.demo.Model.Game;
import javafx.scene.image.Image;
import java.util.Objects;
import javafx.scene.paint.ImagePattern;
public class Bomb extends Weapon {
    public Bomb(Game game) {
        super(game);
    }

    @Override
    public int getDamage() {
        return 2;
    }

    public void move() {
        parentObject.setY(parentObject.getY() + speed);
    }

    public static ImagePattern image = new ImagePattern(new Image(Objects.requireNonNull(Bullet.class.getResource("/com/example/demo/PNG/game/bomb.png")).toExternalForm()));

    @Override
    public ImagePattern getImage() {
        return Bomb.image;
    }

    @Override
    public int getImageHeight() {
        return 38;
    }

    @Override
    public int getImageWidth() {
        return 53;
    }

    public static double speed = 5;


}
