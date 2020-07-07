module S14InputOutputL225 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires junit;
    requires sqlite.jdbc;
    requires java.sql;

    opens S19Databases.l353_358;
    opens S19Databases.l353_358.Controller;
    opens S19Databases.l353_358.Model;
}