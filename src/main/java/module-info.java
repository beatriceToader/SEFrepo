module com.example.sefproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sefproj to javafx.fxml;
    exports com.example.sefproj;
}