package com.example.pokemon_manager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// a user's account and their collections
public class User {
    private String username;
    private String password;
    private String bio;
    private String profilePicturePath;
    private ArrayList<CardCollection> collections = new ArrayList<>();

    // every new user starts with one empty collection
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bio = "";
        this.profilePicturePath = "";
        collections.add(new CardCollection("Collection 1"));
        // set a currentCollectionName value, so it does not keep prompting
            // user for each update/add/delete on CollectionController.java
    }

    // returns true if the password is correct
    public boolean checkPassword(String attempt) {
        return password.equals(attempt);
    }

    // adds a collection of cards (only if the name isn't already used)
    public void addCollection(CardCollection collection) {
        if (getCollection(collection.getName()) == null) {
            collections.add(collection);
        }
    }

    // deletes the collection and all the cards in it
    public void deleteCollection(String name) {
        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i).getName().equals(name)) { // finding the collection
                collections.remove(i); // removing it (and its cards)
                return;
            }
        }
    }

    // returns the collection with that name, if not it returns null
    public CardCollection getCollection(String name) {
        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i).getName().equals(name)) {
                return collections.get(i);
            }
        }
        return null;
    }

    // returns list of card collection names
    public List<String> getCollectionNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < collections.size(); i++) {
            names.addLast(collections.get(i).getName());
        }

        return names;
    }

    // getters/setters
    public String getUsername() { return username; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getProfilePicturePath() { return profilePicturePath; }
    public void setProfilePicturePath(String profilePicturePath) { this.profilePicturePath = profilePicturePath; }
    public ArrayList<CardCollection> getCollections() { return collections; }
}
