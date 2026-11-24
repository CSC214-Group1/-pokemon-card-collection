import java.util.ArrayList;

// a group of cards, like a binder
public class CardCollection implements Collection {
    private String name;
    private ArrayList<Card> cards = new ArrayList<>();
    private double totalValue;

    public CardCollection(String name) {
        this.name = name;
    }

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
                cards.get(i).setStat(newCard.getStat());
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
        double totalValue = 0;
        for (int i = 0; i < cards.size(); i++)
            totalValue += cards.get(i).getCost();

        return totalValue;
    }

    // returns the cards whose name has the text in it
    public ArrayList<Card> search(String text) { return null; }

    // sorts the cards by name, favorites, date, type, rarity, or cost
    public void sort(String sortOption) { }

    // saves the collection as a file so it can be shared
    public void exportToCsv(String filePath) { }
}

