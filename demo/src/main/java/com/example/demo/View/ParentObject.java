package com.example.demo.View;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public abstract class ParentObject extends Rectangle {

    public abstract Pane getPane();

    public ParentObject(double x, double y, double width, double height) {
        super(x, y, width, height);
    }


}
