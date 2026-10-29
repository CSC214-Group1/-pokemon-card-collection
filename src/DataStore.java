import java.util.ArrayList;

// saves and loads all the app's data
public interface DataStore {
    ArrayList<User> loadUsers();
    void saveUsers(ArrayList<User> users);
    void loadCollections(User user);
    void saveCollections(User user);
}
