package com.example.demo.Controller.transitions;

import com.example.demo.View.MiniBossParentObject;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

public class MiniBossAnimation extends Transition {

    private final MiniBossParentObject object;
    private static final ArrayList<ImagePattern> frames;
    private static final int framesCount = 16;



    @Override
    protected void interpolate(double v) {
        int index = Math.min(framesCount - 1,  (int) Math.floor(v * framesCount));
        object.getMiniBoss().move();
        object.setFill(frames.get(index));
    }
    public MiniBossAnimation(MiniBossParentObject object) {
        this.object = object;
        setCycleDuration(Duration.seconds(4));
        setCycleCount(-1);
    }

    static {
        frames = new ArrayList<>();
        int i = 0;
        while(i < framesCount){
            frames.add(new ImagePattern(new Image(Objects.requireNonNull(PlaneAnimation.class.getResource("/com/example/demo/PNG/bird/bird_" + Integer.toString(i+1) + ".png")).toExternalForm())));
            i++;
        }


    }




}
