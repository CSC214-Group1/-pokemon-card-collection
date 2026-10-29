import java.util.ArrayList;

// a group of cards, like a binder
public class CardCollection implements Collection {
    private String name;
    private ArrayList<Card> cards;
    private double totalValue;

    // edit collection
    public void addCard(Card card) { }
    public void removeCard(Card card) { }
    public void updateCard(Card card) { } // e.g., can change/set name of cards

    // adds up the cost of every card in the collection
    public double getTotalValue() { return totalValue; }

    // returns the cards whose name has the text in it
    public ArrayList<Card> search(String text) { return null; }

    // sorts the cards by name, favorites, date, type, rarity, or cost
    public void sort(String sortOption) { }

    // saves the collection as a file so it can be shared
    public void exportToCsv(String filePath) { }
}

