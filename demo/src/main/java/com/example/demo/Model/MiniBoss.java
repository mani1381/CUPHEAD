package com.example.demo.Model;

import com.example.demo.Controller.transitions.DeathAnimation;
import javafx.scene.media.AudioClip;
import com.example.demo.View.MiniBossParentObject;
import javafx.scene.layout.Pane;
import com.example.demo.View.ParentObject;
import java.util.Objects;
public class MiniBoss implements vulnerable {
    private static final int speed = 4;
    private static final int groupSize = 5;
    private MiniBossParentObject object;
    private Game game;
    private int health;


    public MiniBoss(Game game) {

        game.getDamageable().add(this);
        this.game = game;
        health = 2;

    }

    public static void generateGroup(int y, Pane parent, Game game) {
        int i =1;
        while(i <= groupSize) {
            new MiniBossParentObject((int) (parent.getWidth() + i * 300), y, parent, game);
            i++;
        }
    }




    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void dealDamage(int damage) {
        health -= damage;
    }

    @Override
    public void remove() {
        game.getDamageable().remove(this);
        death();
    }


    public void setObject(MiniBossParentObject object) {
        this.object = object;
    }

    public void move() {
        object.setX(object.getX() - speed);
    }

    public ParentObject getParentObject() {
        return object;
    }


    public void death() {
        DeathAnimation animation = new DeathAnimation(object);
        animation.setOnFinished(actionEvent -> object.getPane().getChildren().remove(object));
        AudioClip audioClip = new AudioClip(Objects.requireNonNull(getClass().getResource("/com/example/demo/MP3/birds.wav")).toString());
        audioClip.play();
        animation.play();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getHealth() {
        return health;
    }

    public Game getGame() {
        return game;
    }

}
