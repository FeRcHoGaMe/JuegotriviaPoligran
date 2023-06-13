/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegotrivia;

import java.awt.Button;
import java.awt.Label;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import javafx.fxml.Initializable;

public class Juegocontroller1 {

@FXML private Label labelpregunta;
@FXML private Label opcion1;
@FXML private Label opcion2;
@FXML private Label opcion3;
@FXML private Label opcion4;
    
public void initialize(URL url, ResourceBundle rb) {
        
    } 

@FXML private void empezar() {
        if (n_pregunta == cantidadDePreguntas) {
            System.exit(0);
        }
        escogerPregunta(n_pregunta);
        mostrarPregunta();
        n_pregunta++;
    }

    static String BURL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSC1DCoh-Wb7Mhq32pqdsxPZdxTmXtapv-Hb57rPF_hOk65mQwNRt9NmOs2z3reX8SQjXmzeOiB9cJh/pub?output=tsv";
    static String textoBaseDePreguntas = LeerArchivo_ASCII(BURL);
    static String[] renglones = textoBaseDePreguntas.split("\n");
    static int cantidadDePreguntas = renglones.length;

    static String[][] baseDePreguntas = new String[cantidadDePreguntas][5];

    String[] preguntaEscogida;
    String pregunta;
    String respuesta;
    String img;
    ArrayList<String> Opciones = new ArrayList<>();

    int n_pregunta = 0;

    
   public void escogerPregunta(int n) {
        preguntaEscogida = baseDePreguntas[n];
        pregunta = preguntaEscogida[0];
        respuesta = preguntaEscogida[1];
        if (preguntaEscogida.length > 5) {
            img = preguntaEscogida[5];
        } else {
            img = "";
        }
        Opciones.clear();
        for (int i = 1; i < 5; i++) {
            Opciones.add(preguntaEscogida[i]);
        }
        for (int i = 0; i < 4; i++) {
            Collections.shuffle(Opciones);
        }
    }

    public void mostrarPregunta() {
        labelpregunta.setText(pregunta);
        opcion1.setText(Opciones.get(0));
        opcion2.setText(Opciones.get(1));
        opcion3.setText(Opciones.get(0));
        opcion4.setText(Opciones.get(0));

    }
    
    public void escogerRespuesta(int n) {
        if (Opciones.get(n).equals(respuesta)) {
            
        } else {
                   }
        empezar();
    }
   

    public static String LeerArchivo_ASCII(String ruta) {
        try {
            if (ruta == null) {
                throw new RuntimeException("Error, la URL de lectura no puede ser nula");
            }
            URL url = new URL(ruta);
            URLConnection conexión = url.openConnection();
            InputStreamReader isr = new InputStreamReader(conexión.getInputStream());
            return LeerArchivo_ASCII(isr);
        } catch (Exception e) {
            System.out.println("No hay conexión a internet, la base de datos no pudo ser cargada");
            System.exit(0);
        }
        return "";
    }

    public static String LeerArchivo_ASCII(Reader reader) throws Exception {
        BufferedReader br = new BufferedReader(reader);
        String texto = "";
        String linea;
        boolean primerRenglón = true;
        while ((linea = br.readLine()) != null) {
            if (primerRenglón) {
                primerRenglón = false;
            } else {
                texto += "\n";
            }
            texto += linea;
        }
        reader.close();
        br.close();
        return texto;
    }
}

