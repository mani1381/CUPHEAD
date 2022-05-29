package com.example.demo.View;

import com.example.demo.Controller.transitions.BossAnimation;
import com.example.demo.Model.Boss;
import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
public class BossParentObject extends ParentObject {

    public Boss getBoss() {
        return boss;
    }

    private final Pane parent;

    @Override
    public Pane getPane() {
        return parent;
    }
    private final Boss boss;
    public BossParentObject(Pane parent, Boss boss) {
        super(850, (parent.getPrefHeight() - 260) / 2, 325, 260);
        this.parent = parent;
        setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResource("/com/example/demo/PNG/boss/normal/1.png")).toExternalForm())));
        this.boss = boss;
        boss.setObject(this);
        (new BossAnimation(this)).play();
    }


}
