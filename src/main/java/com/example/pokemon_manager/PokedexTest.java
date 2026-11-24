package com.example.pokemon_manager;

// prints every pokemon from pokedex.json
public class PokedexTest {
    public static void main(String[] args) {
        PokemonDatabase database = new PokemonDatabase();
        database.printAllNames();

        System.out.println(database.searchNames("char"));
    }
}
