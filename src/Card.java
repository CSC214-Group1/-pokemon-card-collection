// represents one pokémon card
public class Card {
    private String name;
    private String type;
    private String condition;
    private int HP;
    private double cost;
    private double rarity;
    private boolean isFavorite;
    private String dateAdded;

    // sets card as favorite
    public void setFavorite(boolean favorite) { }

    // returns the cost
    public double getCost() { return cost; }
}