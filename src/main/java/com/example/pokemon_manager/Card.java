package com.example.pokemon_manager;
import java.util.Date;

// represents one pokémon card
public class Card {
    private String condition;
    private double cost;
    private double rarity;
    private boolean isFavorite;
    private String dateAdded; // immutable

    // attributes from pokedex.json
    private int id; // immutable
    private String name;
    private String type[];
    private int stat[]; // HP, ATK, DEF, SP_ATK, SP_DEF, SPD

    // Requires this when creating an initial card
    public Card(String condition, double cost, double rarity, boolean isFavorite, int id, String name, String[] type, int[] stat) {
        this.condition = condition;
        this.cost = cost;
        this.rarity = rarity;
        this.isFavorite = isFavorite;
        this.dateAdded = new Date().toString();
        this.id = id;
        this.name = name;
        this.type = type;
        this.stat = stat;
    }

    // getters/setters
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public double getRarity() { return rarity; }
    public void setRarity(double rarity) { this.rarity = rarity; }
    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
    public String getDateAdded() { return dateAdded; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String[] getType() { return type; }
    public void setType(String[] type) { this.type = type; }
    public int[] getStat() { return stat; }
    public void setStat(int[] stat) { this.stat = stat; }
}