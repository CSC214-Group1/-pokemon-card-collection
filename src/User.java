import java.util.ArrayList;

// a user's account and their collections
public class User {
    private String username;
    private String password;
    private String bio;
    private String profilePicturePath;
    private ArrayList<CardCollection> collections;

    // returns true if the password is correct
    public boolean checkPassword(String attempt) { return false; }

    // adds a collection of cards
    public void addCollection(CardCollection collection) { }

    // deletes the collection and all the cards in it
    public void deleteCollection(String name) { }

    // returns the collection with that name, if not it returns null
    public CardCollection getCollection(String name) { return null; }
}