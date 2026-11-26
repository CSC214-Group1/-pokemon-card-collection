package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SettingsController {
    @FXML
    private Button selectCollectionBtn;

    // TODO: This method already exists in CollectionController.java
        // refactor so it only exists in one central place
    protected String getUserSelection(String name, String prompt, List<String> choices) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.isEmpty() ? null : choices.get(0), choices);

        dialog.setTitle(name);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);
        Optional<String> result = dialog.showAndWait();

        return result.orElse(null);
    }

    @FXML
    private void initialize() {
        themeChoice.getItems().setAll(themes.keySet());
        themeChoice.setValue(MainApplication.getSelectedTheme());

        // if user has selected a collection, the button will relflect
        if (MainApplication.user.isHasSelectedCollection())
            selectCollectionBtn.setText(MainApplication.user.getCurrentCollection() + " *");
    }

    @FXML
    protected void onSelectCollectionBtnClick(ActionEvent event) throws IOException {
        // prompts to select collection
        String result = getUserSelection("Collection List", "Select collection:", MainApplication.user.getCollectionNames());
        MainApplication.user.setCurrentCollection(result); // setting currentCollection
        MainApplication.user.setHasSelectedCollection(true);

        // loads collection
        MainApplication.loadNewScene(event, "collection.fxml"); // loads initial
    }

    private ComboBox<String> themeChoice = new ComboBox<>();

    private final Map<String, String> themes = Map.of(
            "Dark", "themes/dark.css",
            "Light", "themes/light.css",
            "Brian", "themes/brian.css"
    );


    @FXML
    protected void onLogoutBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "login.fxml");
    }

    @FXML
    private void onThemeChanged(ActionEvent event) {
        String theme = themeChoice.getValue();
        String cssPath = themes.get(theme);

        if (cssPath == null) {
            return;
        }

        MainApplication.setSelectedTheme(theme);

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
