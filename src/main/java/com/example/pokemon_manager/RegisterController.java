package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class RegisterController {
    @FXML
    protected void onRegisterBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "license.fxml");
    }

    @FXML
    protected void onLoginBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "login.fxml");
    }
}
