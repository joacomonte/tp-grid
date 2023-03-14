module com.example.gamep3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamep3 to javafx.fxml;
    exports com.example.gamep3;
}