module com.example.pokemon_manager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pokemon_manager to javafx.fxml;
    exports com.example.pokemon_manager;
}