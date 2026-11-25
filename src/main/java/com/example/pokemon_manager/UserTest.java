package com.example.pokemon_manager;

// tests making a user and their collections in the terminal
public class UserTest {
    public static void main(String[] args) {
        User user = new User("ash", "pikachu123");

        // password check
        System.out.println("Right password: " + user.checkPassword("pikachu123"));
        System.out.println("Wrong password: " + user.checkPassword("wrong"));

        // every new user starts with one collection
        System.out.println("Starting collections: " + user.getCollections().size());

        // making new collections
        user.addCollection(new CardCollection("Main binder"));
        user.addCollection(new CardCollection("Trade binder"));
        user.addCollection(new CardCollection("Main binder")); // same name, shouldn't be added
        System.out.println("After adding: " + user.getCollections().size());

        // finding a collection by name
        System.out.println("Found: " + user.getCollection("Main binder").getName());
        System.out.println("Not found: " + user.getCollection("Fake binder"));

        // deleting a collection
        user.deleteCollection("Trade binder");
        System.out.println("After deleting: " + user.getCollections().size());
    }
}
