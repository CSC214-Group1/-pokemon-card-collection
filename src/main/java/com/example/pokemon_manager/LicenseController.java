package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class LicenseController {
    @FXML
    protected void onPurchaseBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "collection1.fxml");
    }

    @FXML
    protected void onContinueFreeBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "collection1.fxml");
    }
}
