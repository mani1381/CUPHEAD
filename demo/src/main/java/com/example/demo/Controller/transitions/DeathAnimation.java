package com.example.demo.Controller.transitions;


import com.example.demo.View.MiniBossParentObject;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.*;
import java.util.*;

public class DeathAnimation extends Transition {
    private final MiniBossParentObject object;
    private static final ArrayList<ImagePattern> frames;
    private static final int framesCount = 11;

    @Override
    protected void interpolate(double v) {
        int index = Math.min(framesCount - 1, (int) Math.floor(v * framesCount));
        object.getMiniBoss().move();
        object.setFill(frames.get(index));
    }

    public DeathAnimation(MiniBossParentObject object) {
        this.object = object;
        setCycleDuration(Duration.millis(500));
        setCycleCount(1);
    }

    static {
        frames = new ArrayList<>();
        for (int i = 0; i < framesCount; i++)
            frames.add(new ImagePattern(new Image(Objects.requireNonNull(PlaneAnimation.class.getResource("/com/example/demo/PNG/bird/death/" + Integer.toString(i+1) + ".png")).toExternalForm())));
    }




}
