package com.example.demo.View;
import com.example.demo.Controller.transitions.WeaponAnimation;
import com.example.demo.Model.Weapons.Weapon;
import javafx.scene.layout.Pane;

public class WeaponParentObject extends ParentObject {

    @Override
    public Pane getPane() {
        return pane;
    }
    private final Pane pane;

    public WeaponParentObject(Pane parent, Weapon weapon) {
        super(weapon.getGame().getCupHead().getObject().getX(), weapon.getGame().getCupHead().getObject().getY(), weapon.getImageWidth(), weapon.getImageHeight());
        this.pane = parent;
        pane.getChildren().add(this);
        weapon.setObject(this);
        pane.getChildren().get(0).requestFocus();
        setFill(weapon.getImage());
        (new WeaponAnimation(weapon)).play();
    }

}
