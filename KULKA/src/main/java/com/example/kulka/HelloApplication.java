package com.example.kulka;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private static final double BALL_RADIUS = 30;
    private static final double SPEED = 5;

    private double ballXSpeed = SPEED;
    private double ballYSpeed = SPEED;

    @Override
    public void start(Stage primaryStage) {
        // Tworzenie kulki
        Sphere kulka = new Sphere(BALL_RADIUS);
        kulka.setTranslateX(250);
        kulka.setTranslateY(200);
        kulka.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLUEVIOLET));


        Group kula = new Group(kulka);


        Scene scene = new Scene(kula, 500, 400);
        scene.setFill(Color.RED);


        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                kulka.setTranslateX(kulka.getTranslateX() + ballXSpeed);
                kulka.setTranslateY(kulka.getTranslateY() + ballYSpeed);

                if (kulka.getTranslateX() <= 0 || kulka.getTranslateX() >= scene.getWidth() - 2 * BALL_RADIUS) {
                    ballXSpeed *= -1;
                }
                if (kulka.getTranslateY() <= 0 || kulka.getTranslateY() >= scene.getHeight() - 2 * BALL_RADIUS) {
                    ballYSpeed *= -1;
                }
            }
        };
        animation.start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kuleczka");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}