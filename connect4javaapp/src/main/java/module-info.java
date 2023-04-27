module com.example.connect4javaapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.connect4javaapp to javafx.fxml;
    exports com.example.connect4javaapp;
}