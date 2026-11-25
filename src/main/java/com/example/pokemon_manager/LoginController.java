package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class LoginController {
    @FXML
    protected void onSignInBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "collection.fxml");
    }

    @FXML
    protected void onRegisterBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "register.fxml");
    }
}
