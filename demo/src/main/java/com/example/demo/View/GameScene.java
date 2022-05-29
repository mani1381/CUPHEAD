package com.example.demo.View;

import com.example.demo.Main;
import com.example.demo.Model.AirPlane;
import com.example.demo.Model.Boss;
import com.example.demo.Model.Game;
import com.example.demo.Model.MiniBoss;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.util.Objects;
import java.util.Random;

public class GameScene {

    private void init() {
        initMedia();
        initTimeLines();
        statistics = new Statistics(parent, game);
    }

    private void initTimeLines() {


        Timeline updater = new Timeline(new KeyFrame(Duration.millis(500), actionEvent -> statistics.updateStatistics()));
        Timeline bossAttack = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> game.getBoss().fire()));
        Timeline miniBossGenerator = new Timeline(new KeyFrame(Duration.seconds(4), actionEvent -> MiniBoss.generateGroup(300 + (new Random()).nextInt((int) (parent.getHeight() - 500)), parent, game)));
        updater.setCycleCount(Animation.INDEFINITE);
        bossAttack.setCycleCount(Animation.INDEFINITE);
        miniBossGenerator.setCycleCount(Animation.INDEFINITE);
        updater.play();
        bossAttack.play();
        miniBossGenerator.play();


    }

    private final Game game;
    private Pane parent;
    private Statistics statistics;




    public GameScene() {
        game = new Game();
    }

    public Scene getScene() throws Exception {
        System.out.println(getClass().getResource("GameScreen.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        parent = fxmlLoader.load();

        Boss boss = game.getBoss();
        BossParentObject bossObject = new BossParentObject(parent, boss);

        AirPlane airPlane = game.getCupHead();

        PlaneParentObject object = new PlaneParentObject(parent, airPlane);


        parent.getChildren().add(object);
        parent.getChildren().add(bossObject);

        parent.getChildren().get(0).requestFocus();
        init();
        return new Scene(parent);
    }
    private void initMedia() {

        Main.mediaPlayer = new MediaPlayer(new Media(Objects.requireNonNull(getClass().getResource("/com/example/demo/MP3/GameMusic.mp3")).toString()));
        Main.mediaPlayer.setCycleCount(-1);
        Main.mediaPlayer.setVolume(0.9);
        Main.mediaPlayer.play();
    }

}
