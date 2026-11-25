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
    protected void onLogoutBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "login.fxml");
    }
}
