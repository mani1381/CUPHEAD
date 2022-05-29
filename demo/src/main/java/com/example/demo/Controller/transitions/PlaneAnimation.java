package com.example.demo.Controller.transitions;

import com.example.demo.View.PlaneParentObject;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

public class PlaneAnimation extends Transition {

    private static final int framesCount = 41;
    private static final ArrayList<ImagePattern> frames;

    @Override
    protected void interpolate(double v) {
        int index = Math.min(framesCount - 1, (int) Math.floor(v * framesCount));
        object.getPlane().killMiniBosses();
        object.getPlane().move();
        object.setFill(frames.get(index));
    }
    private final PlaneParentObject object;


    public PlaneAnimation(PlaneParentObject object) {
        this.object = object;
        setCycleDuration(Duration.seconds(4));
        setCycleCount(-1);
    }

    static {
        frames = new ArrayList<>();
        int i = 0;
        while(i < framesCount)
        {
            frames.add(new ImagePattern(new Image(Objects.requireNonNull(PlaneAnimation.class.getResource("/com/example/demo/PNG/plane/" + Integer.toString(i+1) + ".png")).toExternalForm())));
            i++;
        }
    }





}
