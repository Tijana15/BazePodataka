package main.java.org.unibl.etf.projekat_bp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PrvaScena.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image ikonica=new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("ikonica.png")));
        stage.getIcons().add(ikonica);

        stage.setTitle("Drogerija - kozmetička radnja");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}