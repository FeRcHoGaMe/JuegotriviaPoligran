package com.mycompany.juegotrivia;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void prueba() throws IOException {
        App.setRoot("crearusuario");
    }
    
     @FXML
    private void iniciarcategorias() throws IOException {
        App.setRoot("escogercategoria");
    }
}