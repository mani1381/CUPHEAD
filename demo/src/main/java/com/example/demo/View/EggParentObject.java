package com.example.demo.View;

import com.example.demo.Controller.transitions.EggAnimation;
import com.example.demo.Model.Egg;
import javafx.scene.layout.Pane;

public class EggParentObject extends ParentObject {
    @Override
    public Pane getPane() {
        return pane;
    }

    public EggParentObject(Pane parent, Egg egg) {
        super(egg.getGame().getBoss().getParentObject().getX() + 30, egg.getGame().getBoss().getParentObject().getY() + 80, egg.getImageWidth(), egg.getImageHeight());
        setFill(egg.getImage());
        this.pane = parent;
        pane.getChildren().add(this);
        pane.getChildren().get(0).requestFocus();
        (new EggAnimation(egg)).play();
        egg.setObject(this);
    }

    private final Pane pane;


}
