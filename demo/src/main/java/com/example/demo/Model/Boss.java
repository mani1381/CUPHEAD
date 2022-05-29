package com.example.demo.Model;


import com.example.demo.Main;
import com.example.demo.View.*;
import javafx.stage.Stage;

public class Boss implements vulnerable {

    private int health = 100;
    private Game game;
    private int dy = 1;
    private BossParentObject object;


    public Boss(Game game) {
        this.game = game;
        game.getDamageable().add(this);
    }


    public void fire() {
        Egg egg = new Egg(game);

        new EggParentObject(object.getPane(), egg);
    }

    public boolean isDead() {
        return health <= 0;
    }


    @Override
    public void remove() {
        Main.saveData.saveUsers(Main.database);
        Stage stage = (Stage) this.getParentObject().getScene().getWindow();
        stage.close();

    }

    public void move() {
        object.setY(object.getY() + dy);
        if (object.getY() == 0) dy = 1;
        if (object.getY() == object.getPane().getHeight() - object.getHeight()) dy = -1;
    }


    public ParentObject getParentObject() {
        return object;
    }

    public void setObject(BossParentObject object) {
        this.object = object;
    }


    public void dealDamage(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
