module com.example.demo {
    requires javafx.web;
    requires javafx.controls;
    requires com.google.gson;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.demo;
    opens com.example.demo.View.MenuControllers to javafx.fxml;
    opens com.example.demo.Controller.transitions to javafx.fxml;
    opens com.example.demo.Model to com.google.gson;
    exports com.example.demo.Controller;
    exports com.example.demo.View;
}