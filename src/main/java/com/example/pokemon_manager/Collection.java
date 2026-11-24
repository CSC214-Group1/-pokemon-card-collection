package com.example.pokemon_manager;
import java.util.ArrayList;

public interface Collection {
    void addCard(Card card);
    void removeCard(Card card);
    void updateCard(Card card, Card newCard);
    ArrayList<Card> search(String text);
    void sort(String sortOption);
}
