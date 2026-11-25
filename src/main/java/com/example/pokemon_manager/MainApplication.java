package com.example.pokemon_manager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class MainApplication extends Application {
    protected static User user = new User("Ash", "Pikachu123");
    private static String selectedTheme = "Dark";

    private static final Map<String, String> THEMES = Map.of(
            "Dark", "themes/dark.css",
            "Light", "themes/light.css",
            "Brian", "themes/brian.css"
    );

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), stage.getWidth(), stage.getHeight());
        applyTheme(scene);

        stage.setTitle("Pokemon Card Collection");
        stage.setScene(scene);
        stage.show();
    }

    // method for controllers to change page
    public static String getSelectedTheme() {
        return selectedTheme;
    }

    public static void setSelectedTheme(String theme) {
        if (THEMES.containsKey(theme)) {
            selectedTheme = theme;
        }
    }

    private static void applyTheme(Scene scene) {
        String cssPath = THEMES.get(selectedTheme);
        var stylesheet = MainApplication.class.getResource(cssPath);

        if (stylesheet == null) {
            throw new IllegalStateException("Stylesheet not found: " + cssPath);
        }

        scene.getRoot().getStylesheets().setAll(stylesheet.toExternalForm());
    }

    // Method for controllers to change page
    public static void loadNewScene(ActionEvent event, String sceneName)
            throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(sceneName));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load(), stage.getWidth(), stage.getHeight());

        applyTheme(scene);

        stage.setScene(scene);
        stage.show();
    }
}
