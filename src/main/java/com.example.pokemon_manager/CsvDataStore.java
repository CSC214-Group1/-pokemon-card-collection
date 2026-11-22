import java.util.ArrayList;

// saves and loads data using csv files
public class CsvDataStore implements DataStore {
    private String usersFile = "users.csv";

    public ArrayList<User> loadUsers() { return null; }
    public void saveUsers(ArrayList<User> users) { }
    public void loadCollections(User user) { }
    public void saveCollections(User user) { }
}
