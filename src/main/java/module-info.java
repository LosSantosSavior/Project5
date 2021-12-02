module com.example.project5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.project5 to javafx.fxml;
    exports com.example.project5;
}