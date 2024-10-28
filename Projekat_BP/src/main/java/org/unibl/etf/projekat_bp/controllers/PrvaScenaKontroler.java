package org.unibl.etf.projekat_bp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bp.HelloApplication;

import java.io.IOException;
import java.util.Objects;

public class PrvaScenaKontroler {

    @FXML
    void onPregledRacuna(ActionEvent event) throws IOException {

        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PregledRacuna.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 363);

        stage.setTitle("Pregled računa");
        stage.setScene(scene);

        Image ikonica = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("SifarnikProizvodaSlicica.png")));
        stage.getIcons().add(ikonica);
        stage.setResizable(false);

        stage.show();

    }

    @FXML
    void onProdajniArtikliMenuItem(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SifarnikProdajnihArtikala.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 400);

        stage.setTitle("Šifarnik prodajnih artikala");
        stage.setScene(scene);

        Image ikonica = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("SifarnikProizvodaSlicica.png")));
        stage.getIcons().add(ikonica);
        stage.setResizable(false);

        stage.show();
    }

    @FXML
    void onKategorijeMenuItem(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SifarnikKategorija.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Šifarnik kategorija");
        stage.setScene(scene);

        Image ikonica = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("SifarnikProizvodaSlicica.png")));
        stage.getIcons().add(ikonica);
        stage.setResizable(false);

        stage.show();
    }

    @FXML
    void onIzdavanjeRacuna(ActionEvent event) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("IzdavanjeRacuna.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 761, 448);

        stage.setTitle("Izdavanje računa");
        stage.setScene(scene);

        Image ikonica = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("SifarnikProizvodaSlicica.png")));
        stage.getIcons().add(ikonica);
        stage.setResizable(false);

        stage.show();
    }
}
