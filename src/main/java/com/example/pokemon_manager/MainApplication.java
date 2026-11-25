package com.example.pokemon_manager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Pokemon Card Collection");
        stage.setScene(scene);
        stage.show();
    }

    // method for controllers to change page
    public static void loadNewScene(ActionEvent event, String sceneName) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(sceneName));
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load(), stage.getWidth(), stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }
}
