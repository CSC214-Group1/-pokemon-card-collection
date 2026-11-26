package com.example.pokemon_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

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

    @FXML
    private Button selectCollectionBtn;

    protected String getUserInput(String name, String prompt) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(name);
        dialog.setGraphic(null);
        dialog.setHeaderText(null);
        dialog.setContentText(prompt);

        Optional<String> result = dialog.showAndWait();

        return result.orElse(null);
    }

    protected Card getCardInput(String title, String pokemonName) {
        Dialog<Void> dialog = new Dialog<>();
        DialogPane pane = dialog.getDialogPane();

        VBox box = new VBox(5);

        // condition, cost, rarity, {false}, {1}, types, HP, ATK, DEF, SP_ATK, SP_DEF, SPD
        TextField condition = new TextField();
        Label conditionLabel = new Label("Condition");
        TextField cost = new TextField();
        Label costLabel = new Label("Cost ($)");
        TextField rarity = new TextField();
        Label rarityLabel = new Label("Rarity (value)");
        TextField types = new TextField();
        Label typesLabel = new Label("Types");
        TextField HP = new TextField();
        Label HP_Label = new Label("HP");
        TextField ATK = new TextField();
        Label ATK_Label = new Label("ATK");
        TextField DEF = new TextField();
        Label DEF_Label = new Label("DEF");
        TextField SP_ATK = new TextField();
        Label SP_ATK_Label = new Label("SP ATK");
        TextField SP_DEF = new TextField();
        Label SP_DEF_Label = new Label("SP DEF");
        TextField SPD = new TextField();
        Label SPD_Label = new Label("SPD");

        box.getChildren().addAll(
                conditionLabel, condition, costLabel, cost, rarityLabel,
                rarity, typesLabel, types, HP_Label, HP, ATK_Label, ATK,
                DEF_Label, DEF, SP_ATK_Label , SP_ATK, SP_DEF_Label, SP_DEF,
                SPD_Label, SPD
        );

        dialog.setTitle(title);
        pane.setContent(box);
        pane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialog.showAndWait();

        return new Card(
                condition.getText(), Integer.parseInt(cost.getText()), Double.parseDouble(rarity.getText()),
                false, 1, pokemonName, new String[]{types.getText()},
                new HashMap<>(){{
                    put("HP", Integer.parseInt(HP.getText()));
                    put("ATK", Integer.parseInt(ATK.getText()));
                    put("DEF", Integer.parseInt(DEF.getText()));
                    put("SP_ATK", Integer.parseInt(SP_ATK.getText()));
                    put("SP_DEF", Integer.parseInt(SP_DEF.getText()));
                    put("SPD", Integer.parseInt(SPD.getText()));
                }}
        );
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

    // TODO: Change image file, so it reflects ID of selected pokemon
    private VBox displayCard(String pokemonName, String[] pokeTypes, HashMap<String, Integer> pokeStats) throws FileNotFoundException {
        VBox card = new VBox(8);
        card.getStyleClass().add("pokemon-card");

        Label name = new Label(pokemonName);
        name.getStyleClass().add("pokemon-name");
        VBox.setMargin(name, new Insets(20, 0, 0, 0));

        FileInputStream url = new FileInputStream("src/main/resources/com/example/pokemon_manager/database/pokedex/006.png");
        ImageView image = new ImageView(new Image(url));
        image.setFitHeight(76);
        image.setFitWidth(100);
        image.setPreserveRatio(true);
        image.setSmooth(true);

        StringBuilder typeText = new StringBuilder();
        for (int i = 0; i < pokeTypes.length; i++) {
            typeText.append(pokeTypes[i]).append("   ");
        }
        Label types = new Label(typeText.toString());
        types.getStyleClass().add("type-label");

        Label topStats = new Label(
                "HP " + pokeStats.get("HP").toString() + "   " +
                "ATK " + pokeStats.get("ATK").toString() + "   " +
                "DEF " + pokeStats.get("DEF").toString() + "   "
        );
        topStats.getStyleClass().add("stat");

        Label bottomStats = new Label(
                "SP ATK " + pokeStats.get("SP_ATK").toString() + "   " +
                        "SP DEF " + pokeStats.get("SP_DEF").toString() + "   " +
                        "SPD " + pokeStats.get("SPD").toString() + "   "
        );
        bottomStats.getStyleClass().add("stat");

        card.getChildren().addAll(name, image, types, topStats, bottomStats);

        return card;
    }

    @FXML
    protected void initialize() {
        // if user has selected a collection, the button will show this
        if (MainApplication.user.isHasSelectedCollection())
            selectCollectionBtn.setText(MainApplication.user.getCurrentCollection() + " *");
    }

    @FXML
    protected void onSelectCollectionBtnClick(ActionEvent event) throws IOException {
        // Prompts to select from a list of collection (User.java)
        String result = getUserSelection("Collection List", "Select collection:", MainApplication.user.getCollectionNames());
        MainApplication.user.setCurrentCollection(result); // setting currentCollection
        CardCollection collection = MainApplication.user.getCollection(result);
        MainApplication.user.setHasSelectedCollection(true);

        // reloads collection.fxml with collection details
        pokemonCardContainer.getChildren().clear();
        ArrayList<Card> cards = collection.getCards();
        for (int i = 0; i < cards.size(); i++) { // adding nodes for each card
            pokemonCardContainer.getChildren().add(displayCard(
                    cards.get(i).getName(), cards.get(i).getType(), cards.get(i).getStats()
            ));
        }

        // Changes button text to reflect current selection
        selectCollectionBtn.setText(MainApplication.user.getCurrentCollection() + " *");
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
    protected void onSortCardBtnClick() {
        // use sort() in cardCollection.java
    }

    @FXML
    protected void onAddCardBtnClick() throws IOException {
        PokemonDatabase database = new PokemonDatabase();
        String searchQuery = getUserInput("Add Card", "Search card name:");
        String selection = getUserSelection("Selection", "Select", database.searchNames(searchQuery));
        String collectionName = getUserSelection("Select Collection", "Select a collection", MainApplication.user.getCollectionNames());
        MainApplication.user.getCollection(collectionName).addCard(getCardInput("Add Card", selection));

        // reloads collection.fxml with newly added card in collection
        CardCollection collection = MainApplication.user.getCollection(collectionName);
        pokemonCardContainer.getChildren().clear();
        ArrayList<Card> cards = collection.getCards();
        for (int i = 0; i < cards.size(); i++) { // adding nodes for each card
            pokemonCardContainer.getChildren().add(displayCard(
                    cards.get(i).getName(), cards.get(i).getType(), cards.get(i).getStats()
            ));
        }
    }

    @FXML
    protected void onDeleteCardBtnClick() {

    }

    @FXML
    protected void onUpdateCardBtnClick() {

    }
}