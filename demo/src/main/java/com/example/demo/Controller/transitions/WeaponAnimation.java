package com.example.demo.Controller.transitions;

import com.example.demo.Model.Weapons.Weapon;
import javafx.animation.Transition;
import javafx.util.Duration;

public class WeaponAnimation extends Transition {
    private final Weapon weapon;

    @Override
    protected void interpolate(double v) {
        weapon.move();
        if (weapon.dealDamage()) stop();
    }
    public WeaponAnimation(Weapon weapon) {
        this.weapon = weapon;
        setCycleDuration(Duration.seconds(1));
        setCycleCount(-1);
    }

}
