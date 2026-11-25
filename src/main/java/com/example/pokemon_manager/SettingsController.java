package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class SettingsController {
    @FXML
    protected void onSelectCollectionBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "collection.fxml"); // loads initial
        // prompts to select collection
    }

    @FXML
    protected void onAddCollectionBtnClick(ActionEvent event) throws IOException {
        // Prompts user to set a name for a new collection
        // Adds collection to User.java
    }

    @FXML
    protected void onLogoutBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "login.fxml");
    }
}
