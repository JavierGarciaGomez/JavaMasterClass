module S13JavaFX1 {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;

    opens l183_184GridLayout;
    opens l184_HBoxLayout;
    opens l185BorderPane;
    opens l186_OtherLayouts;
    opens l187_191Controls;
    opens l192_195EventsAndThread;
    opens l196_210SetupSampleApp;
    opens l211_213CSS_JavaFX;
    opens l217_219SceneBuilder;
    opens l220_224Challenge;
    opens l220_224Challenge.datamodel;
}