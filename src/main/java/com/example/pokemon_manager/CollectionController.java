package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // Prompts user to set a name for a new collection
        String input = getUserInput("Add Collection", "Enter name:");
        MainApplication.user.addCollection(new CardCollection(input));
        // Loads collection
    }

    @FXML
    protected void onDeleteCollectionBtnClick(ActionEvent event) throws IOException {
        List<String> collections = new ArrayList<>();
        for (int i = 0; i < MainApplication.user.getCollections().size(); i++) {
            collections.addLast(MainApplication.user.getCollections().get(i).getName());
        }

        String selection = getUserSelection("Collections", "Select Collection", collections);
        MainApplication.user.deleteCollection(selection);
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
    private TilePane pokemonCardContainer;

    @FXML
    protected void onAddCardBtnClick() {
        PokemonDatabase database = new PokemonDatabase();
        String searchQuery = getUserInput("Add Card", "Search card name:");
        String selection = getUserSelection("Selection", "Select", database.searchNames(searchQuery));
        // find selected card details like stats, types, and id
        // create new Card()
        // add card to database
        // show all database cards on UI (use pokemonCardContainer)
    }

}

// TODO: (later use) for stylized dialogue box
//    @FXML
//    private void onCancelBtnClick(ActionEvent event) {
//        Stage dialog = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        dialog.close();
//    }

// TODO: Implement stylized dialogue box & add selection box style
//    @FXML
//    protected void onAddCardBtnClick(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource("addCard.fxml")
//            );
//            Parent dialogRoot = loader.load();
//
//            Stage dialog = new Stage();
//            dialog.setTitle("Add Pokémon Card");
//            dialog.initModality(Modality.APPLICATION_MODAL);
//
//            if (event.getSource() instanceof javafx.scene.Node node
//                    && node.getScene() != null
//                    && node.getScene().getWindow() != null) {
//                var owner = node.getScene().getWindow();
//                dialog.initOwner(owner);
//
//                // Apply the same theme stylesheet(s) as the window that opened this dialog.
//                dialogRoot.getStylesheets().setAll(
//                        node.getScene().getRoot().getStylesheets()
//                );
//            }
//
//            dialog.setScene(new Scene(dialogRoot));
//            dialog.setResizable(false);
//            dialog.showAndWait();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
