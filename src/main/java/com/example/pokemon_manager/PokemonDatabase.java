package com.example.pokemon_manager;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

// the pre smade list of pokemon names users pick from
public class PokemonDatabase {
    private ArrayList<String> pokemonNames = new ArrayList<>();

    // loads the names from pokedex.json
    public PokemonDatabase() {
        InputStream file = PokemonDatabase.class.getResourceAsStream("database/pokedex.json");
        if (file == null) {
            System.out.println("Error: could not find pokedex.json");
            return;
        }

        Scanner scanner = new Scanner(file, "UTF-8");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("\"english\"")) {
                String name = line.split("\"")[3]; 
                pokemonNames.add(name);
            }
        }
        scanner.close();
    }

    public ArrayList<String> getAllNames() { return pokemonNames; }

    // returns the names that have the text in them
    public ArrayList<String> searchNames(String text) {
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < pokemonNames.size(); i++) {
            if (pokemonNames.get(i).toLowerCase().contains(text.toLowerCase())) {
                results.add(pokemonNames.get(i));
            }
        }
        return results;
    }

    // prints every pokemon name in the terminal
    public void printAllNames() {
        for (int i = 0; i < pokemonNames.size(); i++) {
            System.out.println((i + 1) + ". " + pokemonNames.get(i));
        }
    }
}
