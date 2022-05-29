package com.example.demo.View;

import com.example.demo.Main;
import com.example.demo.Model.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Objects;

public class Statistics extends HBox {

    private final Game game;
    private static final ImagePattern bullet = new ImagePattern(new Image(Objects.requireNonNull(Statistics.class.getResource("/com/example/demo/PNG/guntype/bullet.png")).toExternalForm()));
    private static final ImagePattern bomb = new ImagePattern(new Image(Objects.requireNonNull(Statistics.class.getResource("/com/example/demo/PNG/guntype/bomb.png")).toExternalForm()));

    public void updateStatistics() {
        updateBossHP();
        updatePlaneHealth();
        updateGun();
        updateScore();
        updateProgressBar();

    }

    private void updateProgressBar() {
        ((ProgressBar) this.getChildren().get(3)).setProgress((double) game.getBoss().getHealth() / 100);

    }

    private void updateBossHP() {
        if (game.getCupHead().getHealth() <= 10) {
            this.getChildren().get(2).setStyle("-fx-text-fill: green;");
        }
        ((Label) this.getChildren().get(2)).setText("Boss Hp : " + game.getBoss().getHealth() + " / 100");
    }

    private void updateGun() {
        if(game.getCupHead().isOnBullet())
        {
            ((Rectangle) this.getChildren().get(0)).setFill(bullet);
        }
        else{
            ((Rectangle) this.getChildren().get(0)).setFill(bomb);
        }

    }

    private void updatePlaneHealth() {
        if (game.getCupHead().getHealth() <= 5){
            this.getChildren().get(1).setStyle("-fx-text-fill: red;");
        }
        ((Label) this.getChildren().get(1)).setText("CupHead Hp : " + game.getCupHead().getHealth() + " / 10");
    }

    private void updateScore() {
        if (Main.database.getActiveUser() != null) {
            Main.database.getActiveUser().setHighScore(game.getCupHead().getHealth() * 20 - game.getBoss().getHealth());
        }

        ((Label) this.getChildren().get(5)).setText("Score:  " + (game.getCupHead().getHealth() * 20 - game.getBoss().getHealth()));
    }
    public Statistics(Pane pane, Game game) {
        super();
        this.game = game;
        Label display = new Label();
        Label score = new Label();
        score.setTranslateX(400);
        display.setTranslateX(650);

        Timeline stopWatchTimeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            game.setSecond(game.getSecond() + 1);
            if (Main.database.getActiveUser() != null) {
                Main.database.getActiveUser().setTime(String.format("%02d:%02d", (game.getSecond() % 3600) / 60, game.getSecond() % 60));
            }

            display.setText("Time:  " + String.format("%02d:%02d", (game.getSecond() % 3600) / 60, game.getSecond() % 60));
        }));
        stopWatchTimeline.setCycleCount(Timeline.INDEFINITE);
        stopWatchTimeline.play();
        this.getChildren().add(new Rectangle(0, 0, 40, 40));
        Label label = new Label();
        this.getChildren().add(label);
        label = new Label();
        label.setTranslateX(100);
        ProgressBar pb = new ProgressBar(1);
        pb.setTranslateX(300);
        pb.setScaleX(2);
        label.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().add(label);
        this.getChildren().add(pb);
        this.getChildren().add(display);
        this.getChildren().add(score);

        pane.getChildren().add(this);
        pane.getChildren().get(0).requestFocus();
        updateStatistics();
    }







}
