module com.example.justsef {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.justsef to javafx.fxml;
    exports com.example.justsef;
}