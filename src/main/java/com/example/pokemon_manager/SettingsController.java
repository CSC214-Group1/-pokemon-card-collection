package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
}
