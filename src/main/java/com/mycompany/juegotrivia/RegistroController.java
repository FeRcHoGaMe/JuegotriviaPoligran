package com.mycompany.juegotrivia;

import java.io.IOException;
import javafx.fxml.FXML;

public class RegistroController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}