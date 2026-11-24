package com.example.pokemon_manager;
import java.util.HashMap;

public class CollectionTest {
    public static void main(String[] args) {
        // case of a card that would come from pokedex.json & user input
        Card card1 = new Card(
                "Mint", 45, 10, true, 1, "Bulbasaur", new String[]{"Grass", "Poison"},
                new HashMap<>(){{ put("HP", 45); put("ATK", 49); put("DEF", 49); put("SP_ATK", 65); put("SP_DEF", 65); put("SPD", 45); }}
        );
        CardCollection collection1 = new CardCollection("Collection 1");
        collection1.addCard(card1);
        collection1.toggleCardFavoriteStatus(card1);
        System.out.println(collection1.getTotalValue());

        // when updating, it will create a new card, but won't add it to the collection
        Card newCard1 = new Card(
                "Used", 35, 9, false, card1.getId(), "BulbasaurV2", new String[]{"Grass", "Steel"},
                new HashMap<>(){{ put("HP", 55); put("ATK", 45); put("DEF", 65); put("SP_ATK", 66); put("SP_DEF", 67); put("SPD", 44); }}
        );
        newCard1.setDateAdded(card1.getDateAdded()); // making sure dates are consistent
        collection1.updateCard(card1, newCard1);
        System.out.println(collection1.getTotalValue());

        collection1.removeCard(card1);
    }
}