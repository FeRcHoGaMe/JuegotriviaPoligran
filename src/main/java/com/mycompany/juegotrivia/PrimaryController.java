package com.mycompany.juegotrivia;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("iniciarsesion");
    }
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("crearusuario");
    }
}
