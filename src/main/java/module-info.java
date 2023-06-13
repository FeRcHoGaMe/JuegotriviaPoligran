module com.mycompany.juegotrivia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens com.mycompany.juegotrivia to javafx.fxml;
    exports com.mycompany.juegotrivia;
}
