package com.example.demo.View;

import javafx.scene.layout.Pane;
import com.example.demo.Controller.transitions.MiniBossAnimation;
import com.example.demo.Model.*;
public class MiniBossParentObject extends ParentObject {

    @Override
    public Pane getPane() {
        return parent;
    }
    public MiniBossParentObject(int x, int y, Pane parent, Game game) {
        super(x, y, 161, 118);
        this.miniBoss = new MiniBoss(game);
        this.miniBoss.setObject(this);
        this.parent = parent;

        parent.getChildren().add(this);
        (new MiniBossAnimation(this)).play();
    }

    private final Pane parent;
    private final MiniBoss miniBoss;

    public MiniBoss getMiniBoss() {
        return miniBoss;
    }


}
