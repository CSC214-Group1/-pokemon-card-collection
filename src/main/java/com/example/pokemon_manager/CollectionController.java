package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CollectionController {
    @FXML
    private TilePane pokemonCardContainer;

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

    // TODO: Make values inside variable
    private VBox createPokemonCard() throws FileNotFoundException {
        VBox card = new VBox(8);
        card.getStyleClass().add("pokemon-card");

        Label name = new Label("Charizard");
        name.getStyleClass().add("pokemon-name");
        VBox.setMargin(name, new Insets(20, 0, 0, 0));

        FileInputStream url = new FileInputStream("src/main/resources/com/example/pokemon_manager/database/pokedex/006.png");
        ImageView image = new ImageView(new Image(url));
        image.setFitHeight(76);
        image.setFitWidth(100);
        image.setPreserveRatio(true);
        image.setSmooth(true);

        Label types = new Label("Fire   Flying");
        types.getStyleClass().add("type-label");

        Label topStats = new Label("HP 78     ATK 84     DEF 78");
        topStats.getStyleClass().add("stat");

        Label bottomStats = new Label("SP.ATK 100   SP.DEF 109   SPD 85");
        bottomStats.getStyleClass().add("stat");

        card.getChildren().addAll(name, image, types, topStats, bottomStats);

        return card;
    }

    @FXML
    protected void onSelectCollectionBtnClick(ActionEvent event) throws IOException {
        // Prompts to select from a list of collection (User.java)
        ArrayList<String> collectionNames = new ArrayList<>();
        for (int i = 0; i < MainApplication.user.getCollections().size(); i++)
            collectionNames.addLast(MainApplication.user.getCollections().get(i).getName());

        String result = getUserSelection("Collection List", "Select collection:", collectionNames);
        CardCollection collection = MainApplication.user.getCollection(result);

        // test case
        Card card1 = new Card(
                "Mint", 45, 10, true, 1, "Bulbasaur", new String[]{"Grass", "Poison"},
                new HashMap<>(){{ put("HP", 45); put("ATK", 49); put("DEF", 49); put("SP_ATK", 65); put("SP_DEF", 65); put("SPD", 45); }}
        );

        collection.addCard(card1);
        collection.addCard(card1);
        collection.addCard(card1);
        collection.addCard(card1);
        collection.addCard(card1);
        collection.toggleCardFavoriteStatus(card1);

        // reloads collection.fxml with collection details
        ArrayList<Card> cards = collection.getCards();
        pokemonCardContainer.getChildren().clear();
        for (int i = 0; i < cards.size(); i++) { // adding nodes for each card
            System.out.println(cards.get(i).getName());
            pokemonCardContainer.getChildren().add(createPokemonCard());
        }
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
