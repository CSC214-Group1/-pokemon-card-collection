import java.util.ArrayList;

// lets cards be searched and sorted
public interface SearchSort {
    ArrayList<Card> search(String text);
    void sort(String sortOption);
}
