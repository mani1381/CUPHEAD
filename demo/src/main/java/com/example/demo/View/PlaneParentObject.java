package com.example.demo.View;

import com.example.demo.Controller.KeyEventHandler;
import com.example.demo.Controller.transitions.PlaneAnimation;
import com.example.demo.Model.AirPlane;
import javafx.animation.FadeTransition;
import javafx.util.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import java.util.*;
public class PlaneParentObject extends ParentObject {

    public Pane getPane() {
        return pane;
    }
    private final AirPlane airPlane;
    public PlaneParentObject(Pane parent, AirPlane airPlane) {
        super(0, (parent.getPrefHeight() - 98) / 2, 114, 98);
        this.pane = parent;
        setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResource("/com/example/demo/PNG/plane/1.png")).toExternalForm())));
        this.airPlane = airPlane;

        setOnKeyReleased(keyEvent -> {
            KeyEventHandler.releaseKey(keyEvent.getCode().getName());
            if (keyEvent.getCode().getName().equals("Tab")) {
                airPlane.switchGunType();
            }
            else if (keyEvent.getCode().getName().equals("Space")) {
                airPlane.fire();
            }
        });

        setOnKeyPressed(keyEvent -> {
            KeyEventHandler.pressKey(keyEvent.getCode().getName());
            if (keyEvent.getCode().getName().equals("Space")) {
                airPlane.fire();
            }
        });
        airPlane.setObject(this);
        (new PlaneAnimation(this)).play();

    }
    private final Pane pane;
    public AirPlane getPlane() {
        return airPlane;
    }

    public void blink() {

        FadeTransition transition = new FadeTransition(Duration.millis(333), this);
        transition.setToValue(1.0);
        transition.setFromValue(0.1);

        System.out.println(airPlane.getHealth());

        transition.setOnFinished(actionEvent -> airPlane.setCanBeDied(false));

        System.out.println(airPlane.getHealth());

        transition.setAutoReverse(true);

        transition.setCycleCount(5);

        transition.play();
    }


}
