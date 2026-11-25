package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class CollectionController {
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
    protected void onSettingsBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "settings.fxml");
    }

    @FXML
    protected void onAddCardBtnClick() {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Add Card");
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setContentText("Search card name:");

        Optional<String> result = dialog.showAndWait();

        // Will search using search() and add to the pokemonCardContainer HBox
        result.ifPresent(cardName -> {
            return;
        });
    }
}
