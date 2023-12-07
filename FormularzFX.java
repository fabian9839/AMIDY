package com.example.formularzFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FormularzFX extends Application {
    private TextField imieText, nazwiskoText, adresText, miejscowoscText, telefonText, emailText;

    @Override
    public void start(Stage stage) throws IOException {
        createFormElements();

        Button przycisk = new Button("Zatwierdź");
        configureButton(przycisk);

        GridPane gridPane = createGridPane();
        configureGridPane(gridPane);

        configureStage(stage, gridPane);

        przycisk.setOnAction(actionEvent -> handleButtonClick());

        stage.show();
    }

    private void createFormElements() {
        Text imie = createText("Imie");
        imieText = new TextField();

        Text nazwisko = createText("Nazwisko");
        nazwiskoText = new TextField();

        Text adres = createText("Adres");
        adresText = new TextField();

        Text miejscowosc = createText("Miejscowość");
        miejscowoscText = new TextField();

        Text telefon = createText("Telefon");
        telefonText = new TextField();

        Text email = createText("Email");
        emailText = new TextField();
    }

    private Text createText(String label) {
        Text text = new Text(label);
        text.setStyle("-fx-font: normal bold 15px 'Arial'");
        return text;
    }

    private void configureButton(Button button) {
        button.setStyle("-fx-background-color: WHITE; -fx-text-fill: BLACK;");
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 500);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(25);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        addFormElementsToGrid(gridPane);

        return gridPane;
    }

    private void addFormElementsToGrid(GridPane gridPane) {
        gridPane.add(createText("Imie"), 0, 0);
        gridPane.add(imieText, 1, 0);

        gridPane.add(createText("Nazwisko"), 0, 1);
        gridPane.add(nazwiskoText, 1, 1);

        gridPane.add(createText("Adres"), 0, 2);
        gridPane.add(adresText, 1, 2);

        gridPane.add(createText("Miejscowość"), 0, 3);
        gridPane.add(miejscowoscText, 1, 3);

        gridPane.add(createText("Telefon"), 0, 4);
        gridPane.add(telefonText, 1, 4);

        gridPane.add(createText("Email"), 0, 5);
        gridPane.add(emailText, 1, 5);

        gridPane.add(new Button("Zatwierdź"), 1, 6);
        return gridPane;
    }

    private void configureGridPane(GridPane gridPane) {
        gridPane.setStyle("-fx-background-color: MOCCASIN;");
    }

    private void configureStage(Stage stage, GridPane gridPane) {
        Scene scene = new Scene(gridPane);
        stage.setTitle("Formularz JavaFX");
        stage.setScene(scene);
    }

    private void handleButtonClick() {
        if (isValidFormData()) {
            informacja2("Formularz wypełniony prawidłowo!");
        } else {
            informacja("Proszę wypełnić wszystkie pola zgodnie z wymaganiami.");
        }
    }

    private boolean isValidFormData() {
        return prawidloweWartosci(imieText.getText(), nazwiskoText.getText(), adresText.getText(),
                miejscowoscText.getText(), telefonText.getText(), emailText.getText());
    }

    // ... (remaining methods unchanged)

    public static void main(String[] args) {
        launch();
    }
}