package com.example.demo.Model;


import com.example.demo.View.EggParentObject;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.Objects;

public class Egg {
    public static ImagePattern image = new ImagePattern(new Image(Objects.requireNonNull(Egg.class.getResource("/com/example/demo/PNG/game/egg.png")).toExternalForm()));
    public static double speed = 7;

    public ImagePattern getImage() {
        return Egg.image;
    }

    public int getImageHeight() {
        return 50;
    }

    public int getImageWidth() {
        return 60;
    }

    private Game game;

    private EggParentObject object;

    public Egg(Game game) {
        this.game = game;
    }

    public void setObject(EggParentObject object) {
        this.object = object;
    }


    public static void setImage(ImagePattern image) {
        Egg.image = image;
    }


    public void move() {
        object.setX(object.getX() - speed);
    }

    public void remove() {
        object.getPane().getChildren().remove(object);
    }
    public EggParentObject getObject() {
        return object;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }




}
