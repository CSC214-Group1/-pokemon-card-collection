package com.example.pokemon_manager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

// a group of cards, like a binder
public class CardCollection implements Collection {
    private String name;
    private ArrayList<Card> cards = new ArrayList<>();
    private double totalValue = 0;

    public CardCollection(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    // adding card to collection
    public void addCard(Card card) {
        cards.addLast(card);
    }

    // removing card from collection
    public void removeCard(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getId() == card.getId()) { // finding specific card
                cards.remove(i); // removing card
                return; // ends loop once it finds & removes the card
            }
        }
    }

    // e.g., can change/set attributes of cards
    public void updateCard(Card card, Card newCard) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getId() == card.getId()) { // finding specific card
                // updating name, type, condition, cost, rarity, and stats
                cards.get(i).setName(newCard.getName());
                cards.get(i).setType(newCard.getType());
                cards.get(i).setCondition(newCard.getCondition());
                cards.get(i).setCost(newCard.getCost());
                cards.get(i).setRarity(newCard.getRarity());
                cards.get(i).setStats(newCard.getStats());
                return; // ends loop once it finds & updates the card
            }
        }
    }

    // mark/unmark card as a favorite
    public void toggleCardFavoriteStatus(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getId() == card.getId()) { // finding specific card
                cards.get(i).setFavorite(!card.isFavorite()); // toggle favorite
                return; // ends loop once it updates the card
            }
        }
    }

    // adds up the cost of every card in the collection
    public double getTotalValue() {
        totalValue = 0; // reset before adding so it doesn't keep growing
        for (int i = 0; i < cards.size(); i++)
            totalValue += cards.get(i).getCost();

        return totalValue;
    }

    // returns the cards whose name has the text in it
    public ArrayList<Card> search(String text) { return null; }

    // sorts the cards by name, favorites, date, type, rarity, or cost
    public void sort(String sortOption) {
        for (int i = 0; i < cards.size() - 1; i++) {
            for (int j = 0; j < cards.size() - 1 - i; j++) {
                Card a = cards.get(j);
                Card b = cards.get(j + 1);
                boolean swap = false;

                if (sortOption.equals("name")) {
                    if (a.getName().compareToIgnoreCase(b.getName()) > 0) swap = true;
                } else if (sortOption.equals("cost")) {
                    if (a.getCost() < b.getCost()) swap = true;
                } else if (sortOption.equals("favorites")) {
                    if (!a.isFavorite() && b.isFavorite()) swap = true;
                } else if (sortOption.equals("date")) {
                    if (getDate(a) < getDate(b)) swap = true;
                } else if (sortOption.equals("type")) {
                    if (a.getType()[0].compareToIgnoreCase(b.getType()[0]) > 0) swap = true;
                } else if (sortOption.equals("rarity")) {
                    if (a.getRarity() < b.getRarity()) swap = true;
                }

                if (swap) {
                    cards.set(j, b);
                    cards.set(j + 1, a);
                }
            }
        }
    }

    // turns the date text into a number so two dates can be compared
    // pattern from: https://stackoverflow.com/questions/4713825/how-to-parse-output-of-new-date-tostring
    // parse example from: https://mkyong.com/java/how-to-convert-string-to-date-java/
    private long getDate(Card card) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            return format.parse(card.getDateAdded()).getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<Card> getCards() { return cards; }

    // saves the collection as a file, so it can be shared
    public void exportToCsv(String filePath) { }
}
