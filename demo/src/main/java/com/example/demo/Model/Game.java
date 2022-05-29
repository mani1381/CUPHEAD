package com.example.demo.Model;

import java.util.ArrayList;

import javafx.scene.layout.Pane;


public class Game {
    private final ArrayList<vulnerable> vulnerable;
    private final AirPlane cupHead;
    private final Boss boss;
    private int second = 0;
    private Pane parent;


    public Game() {
        cupHead = new AirPlane(this);
        vulnerable = new ArrayList<>();
        boss = new Boss(this);
    }

    public Pane getParent() {
        return parent;
    }

    public void setParent(Pane parent) {
        this.parent = parent;
    }

    public AirPlane getCupHead() {
        return cupHead;
    }

    public ArrayList<vulnerable> getDamageable() {
        return vulnerable;
    }

    public Boss getBoss() {
        return boss;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

}
