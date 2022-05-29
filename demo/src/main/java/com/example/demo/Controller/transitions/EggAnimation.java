package com.example.demo.Controller.transitions;


import com.example.demo.Model.AirPlane;
import com.example.demo.Model.Egg;
import javafx.animation.Transition;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;

public class EggAnimation extends Transition {

    private final Egg egg;

    @Override
    protected void interpolate(double v) {

        Rotate rotate = new Rotate();

        egg.move();

        AirPlane airPlane = egg.getGame().getCupHead();

        rotate.setPivotY(egg.getObject().getY() + egg.getObject().getHeight() / 2);
        rotate.setAngle(360 * v);
        egg.getObject().getTransforms().clear();
        rotate.setPivotX(egg.getObject().getX() + egg.getObject().getWidth() / 2);
        egg.getObject().getTransforms().add(rotate);

        if (airPlane.getObject().intersects(egg.getObject().getLayoutBounds())) {
            try {
                if (airPlane.getHit()) airPlane.getObject().blink();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stop();
            egg.remove();
        }


    }
    public EggAnimation(Egg egg) {
        this.egg = egg;
        setCycleDuration(Duration.seconds(1));
        setCycleCount(-1);
    }



}
