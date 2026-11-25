package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class CollectionController {
    protected String getUserInput(String name, String prompt) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(name);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);

        Optional<String> result = dialog.showAndWait();

        return result.orElse(null);
    }

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
    protected void onSelectCollectionBtnClick(ActionEvent event) throws IOException {
        // Prompts to select from a list of collection (User.java)
        // reloads collection.fxml with collection details
        MainApplication.loadNewScene(event, "collection.fxml");
    }

    @FXML
    protected void onAddCollectionBtnClick(ActionEvent event) throws IOException {
        // Code will be same as in SettingsController (refactor later)
        // Prompts user to set a name for a new collection
        // Adds collection to User.java
    }

    @FXML
    protected void onDeleteCollectionBtnClick(ActionEvent event) throws IOException {
        // Will show a selection menu of collections from User.java
        // When user selects one, it will delete it on User.java's collection
    }

    @FXML
    protected void onUpdateCollectionBtnClick(ActionEvent event) throws IOException {
        // Will show a selection menu of collections from User.java
        // When user selects one, prompt for a new collection name
        // Then, it will update on User.java's collection
    }


    @FXML
    protected void onSettingsBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "settings.fxml");
    }

    @FXML
    protected void onAddCardBtnClick() {
        PokemonDatabase database = new PokemonDatabase();
        String searchQuery = getUserInput("Add Card", "Search card name:");
        String selection = getUserSelection("Selection", "Select", database.searchNames(searchQuery));
        // Add the selected to the UI
    }
}
