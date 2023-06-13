/**
 * 
Calderón Contreras Jessica Lorena 

Scrum Master 

Jlcalderon@poligran.edu.co 

Ruiz Méndez Sergio Manuel    

Product Owner 

smruiz@poligran.edu.co 

Forero Beltrán Luis Fernando 

Analista 

Lfeforero@poligran.edu.co 

Carreño Prieto Jhonatan Arturo   

Administrador BD 

jarcarreno@poligran.edu.co   


 * JavaFX App
 */

package com.mycompany.juegotrivia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}