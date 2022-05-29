package com.example.demo.Controller;
import javafx.animation.*;
import javafx.beans.property.*;
import javafx.util.Duration;
import javafx.scene.layout.Region;


public class BackgroundController {

    public void initialize() {
        DoubleProperty xPosition = new SimpleDoubleProperty(0);
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(xPosition, 0)), new KeyFrame(Duration.seconds(200), new KeyValue(xPosition, -15000)));
        timeline.play();
        xPosition.addListener((observable, oldValue, newValue) -> setBackgroundPositions(content, xPosition.get()));
    }
    public Region content;
    void setBackgroundPositions(Region region, double xPosition) {
        region.setStyle("-fx-background-position: " + "left " + xPosition / 6 + "px bottom," + "left " + xPosition / 3 + "px bottom," + "left " + xPosition + "px top;");
    }

}
