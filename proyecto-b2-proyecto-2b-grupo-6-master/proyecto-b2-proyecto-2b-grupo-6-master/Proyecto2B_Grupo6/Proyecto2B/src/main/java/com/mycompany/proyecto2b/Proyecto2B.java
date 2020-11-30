package com.mycompany.proyecto2b;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class Proyecto2B extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {

        Image icono = new Image("file:tittle.png");
        ViewMain venPrincipal = new ViewMain();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(venPrincipal.showWinMain());

        Scene scene = new Scene(borderPane);

        window.setScene(scene);
        window.setTitle("Naruto");
        window.getIcons().add(icono);
        window.setMinHeight(500);
        window.setMinWidth(650);
        window.show();
       
        
    }

}
