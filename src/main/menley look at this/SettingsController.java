package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import java.util.Map;

import java.io.IOException;

public class SettingsController {
    @FXML
    protected void onCollection1BtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "collection1.fxml");
    }

    @FXML
    protected void onLogoutBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "login.fxml");
    }

    @FXML
    private ComboBox<String> themeChoice;

    private final Map<String, String> themes = Map.of(
            "Dark", "themes/dark.css",
            "Light", "themes/light.css"
    );

    @FXML
    private void initialize() {
        themeChoice.getItems().setAll(themes.keySet());
        themeChoice.setValue("Dark");
    }

    @FXML
    private void onThemeChanged(ActionEvent event) {
        String cssPath = themes.get(themeChoice.getValue());
        if (cssPath == null) {
            return;
        }

        var stylesheet = getClass().getResource(cssPath);
        if (stylesheet == null) {
            throw new IllegalStateException("Stylesheet not found: " + cssPath);
        }

        Node source = (Node) event.getSource();
        source.getScene().getRoot()
                .getStylesheets()
                .setAll(stylesheet.toExternalForm());
    }
}
