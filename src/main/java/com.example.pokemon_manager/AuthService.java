import java.util.ArrayList;

// handles registering and logging in
public class AuthService {
    private ArrayList<User> users;
    private DataStore dataStore;
    private boolean hasAccount;

    // returns true if the account was made, if the username is taken it returns false
    public boolean register(String username, String password) { return false; }

    // returns the user if the login is correct, if not it returns null
    public User login(String username, String password) { return null; }

    public void saveProfile(User user) { }
}
