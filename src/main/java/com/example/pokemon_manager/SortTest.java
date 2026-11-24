package com.example.pokemon_manager;
import java.util.ArrayList;
import java.util.HashMap;

// makes some cards and prints them after each sort
public class SortTest {
    public static void main(String[] args) {
        Card pikachu = new Card("Mint", 12.50, 3, false, 25, "Pikachu", new String[]{"Electric"}, new HashMap<>());
        Card charizard = new Card("Near Mint", 89.99, 5, true, 6, "Charizard", new String[]{"Fire"}, new HashMap<>());
        Card bulbasaur = new Card("Damaged", 2.00, 1, false, 1, "Bulbasaur", new String[]{"Grass"}, new HashMap<>());
        Card greninja = new Card("Lightly Played", 30.00, 4, true, 658, "Greninja", new String[]{"Water"}, new HashMap<>());

        // giving them different dates so we can test sorting by date
        pikachu.setDateAdded("Fri Nov 20 10:00:00 EST 2026");
        charizard.setDateAdded("Sun Nov 15 10:00:00 EST 2026");
        bulbasaur.setDateAdded("Tue Nov 24 10:00:00 EST 2026");
        greninja.setDateAdded("Mon Nov 23 10:00:00 EST 2026");

        CardCollection collection = new CardCollection("Test");
        collection.addCard(pikachu);
        collection.addCard(charizard);
        collection.addCard(bulbasaur);
        collection.addCard(greninja);

        collection.sort("name");
        System.out.println("By name:");
        printCards(collection.getCards());

        collection.sort("cost");
        System.out.println("By cost:");
        printCards(collection.getCards());

        collection.sort("favorites");
        System.out.println("By favorites:");
        printCards(collection.getCards());

        collection.sort("date");
        System.out.println("By date:");
        printCards(collection.getCards());

        collection.sort("type");
        System.out.println("By type:");
        printCards(collection.getCards());

        collection.sort("rarity");
        System.out.println("By rarity:");
        printCards(collection.getCards());
    }

    public static void printCards(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("  " + cards.get(i).getName());
        }
        System.out.println();
    }
}
