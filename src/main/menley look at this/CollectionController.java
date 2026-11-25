package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class CollectionController {
    // all collections will use this controller
    @FXML
    protected void onSettingsBtnClick(ActionEvent event) throws IOException {
        MainApplication.loadNewScene(event, "settings.fxml");
    }

    @FXML

    protected void onAddCardBtnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("addCard.fxml")
            );
            Parent dialogRoot = loader.load();

            Stage dialog = new Stage();
            dialog.setTitle("Add Pokémon Card");
            dialog.initModality(Modality.APPLICATION_MODAL);

            if (event.getSource() instanceof javafx.scene.Node node
                    && node.getScene() != null
                    && node.getScene().getWindow() != null) {
                dialog.initOwner(node.getScene().getWindow());
            }

            dialog.setScene(new Scene(dialogRoot));
            dialog.setResizable(false);
            dialog.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onCancel(ActionEvent event) {
        Stage dialog = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();
        dialog.close();
    }

}

    //protected void onAddCardBtnClick() {
    //    TextInputDialog dialog = new TextInputDialog();

    //    dialog.setTitle("Add Card");
    //    dialog.setGraphic(null);
    //    dialog.setHeaderText(null);
    //    dialog.setContentText("Search card name:");

    //    Optional<String> result = dialog.showAndWait();

        // Will search using search() and add to the pokemonCardContainer HBox
    //    result.ifPresent(cardName -> {
    //        return;
    //    });
    //}
