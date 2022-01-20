module com.example.curiocity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.desktop;


    opens home to javafx.fxml;
    exports home;

}