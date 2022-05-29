package com.example.demo.Model.Weapons;

import com.example.demo.Model.Game;
import com.example.demo.Model.vulnerable;
import javafx.scene.paint.ImagePattern;
import com.example.demo.View.ParentObject;

public abstract class Weapon {
    protected Game game;
    protected ParentObject parentObject;


    public Weapon(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public abstract int getDamage();

    abstract public ImagePattern getImage();

    abstract public int getImageHeight();

    abstract public int getImageWidth();

    public boolean dealDamage() {
        for (vulnerable vulnerable : game.getDamageable()) {
            if (parentObject.intersects(vulnerable.getParentObject().getLayoutBounds())) {
                vulnerable.dealDamage(getDamage());
                remove();
                if (vulnerable.isDead()) vulnerable.remove();
                return true;
            }
        }
        return false;
    }


    public void setObject(ParentObject parentObject) {
        this.parentObject = parentObject;
    }

    public void remove() {
        parentObject.getPane().getChildren().remove(this.parentObject);
    }


    public abstract void move();
}
