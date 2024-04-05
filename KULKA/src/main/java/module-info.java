module com.example.kulka {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kulka to javafx.fxml;
    exports com.example.kulka;
}