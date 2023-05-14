module fr.marie.harrypotterjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens fr.marie.harrypotterjavafx to javafx.fxml;
    exports fr.marie.harrypotterjavafx;
    exports fr.marie.harrypotterjavafx.console;
    opens fr.marie.harrypotterjavafx.console to javafx.fxml;
    exports fr.marie.harrypotterjavafx.interfaceFx;
    opens fr.marie.harrypotterjavafx.interfaceFx to javafx.fxml;
}