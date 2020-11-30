package com.mycompany.proyecto2b;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ViewStatistics {

    Image imagen10, imagen9;
    ImageView imagenView8, imagenView9;
    Label lbVictory1;
    Label lbVictory2;
    Label lbVictoriy3;
    Label lbVictory4;
    Label lbVictory5;
    Label lbVictory6;
    Label lbVictoriy7;

    Button bSelecChar;
    Button bExit;
    Pane window4;
    ViewMain winMain = new ViewMain();

    public ViewStatistics() {
    }
    
    public Parent showView() {
        
        window4 = new Pane();
        window4.setMinSize(700, 600);
        controlImages();
        controlLabels();

        eventViewMain();
        eventExit();

        window4.getChildren().addAll(imagenView8, imagenView9, lbVictory1, lbVictory2,
                lbVictoriy3, lbVictory4, lbVictory5, lbVictory6, lbVictoriy7, bSelecChar, bExit);

        return window4;

    }

    public void controlImages() {

        imagen10 = new Image("file:fondo7.jpg");
        imagenView8 = new ImageView(imagen10);

        imagen9 = new Image("file:tittle.png");
        imagenView9 = new ImageView(imagen9);
        imagenView9.setFitHeight(160);
        imagenView9.setFitWidth(510);
        imagenView9.setTranslateX(300);
        imagenView9.setTranslateY(20);
    }

    public void controlLabels() {

        lbVictory1 = new Label("Usuario1.....................90 Victoria");
        lbVictory2 = new Label("Usuario2.....................80 Victoria");
        lbVictoriy3 = new Label("Usuario3.....................75 Victoria");
        lbVictory4 = new Label("Usuario4.....................70 Victoria");
        lbVictory5 = new Label("Usuario5.....................65 Victoria");
        lbVictory6 = new Label("Usuario6.....................60 Victoria");
        lbVictoriy7 = new Label("Usuario7.....................55 Victoria");

        lbVictory1.setTextFill(Color.web("#000000", 0.8));
        lbVictory2.setTextFill(Color.web("#000000", 0.8));
        lbVictoriy3.setTextFill(Color.web("#000000", 0.8));
        lbVictory4.setTextFill(Color.web("#000000", 0.8));
        lbVictory5.setTextFill(Color.web("#000000", 0.8));
        lbVictory6.setTextFill(Color.web("#000000", 0.8));
        lbVictoriy7.setTextFill(Color.web("#000000", 0.8));

        lbVictory1.setScaleX(2);
        lbVictory1.setScaleY(1);
        lbVictory2.setScaleX(2);
        lbVictory2.setScaleY(1);
        lbVictoriy3.setScaleX(2);
        lbVictoriy3.setScaleY(1);
        lbVictory4.setScaleX(2);
        lbVictory4.setScaleY(1);
        lbVictory5.setScaleX(2);
        lbVictory5.setScaleY(1);
        lbVictory6.setScaleX(2);
        lbVictory6.setScaleY(1);
        lbVictoriy7.setScaleX(2);
        lbVictoriy7.setScaleY(1);
        lbVictory1.setTranslateX(500);
        lbVictory1.setTranslateY(200);
        lbVictory2.setTranslateX(500);
        lbVictory2.setTranslateY(240);
        lbVictoriy3.setTranslateX(500);
        lbVictoriy3.setTranslateY(280);
        lbVictory4.setTranslateX(500);
        lbVictory4.setTranslateY(320);
        lbVictory5.setTranslateX(500);
        lbVictory5.setTranslateY(360);
        lbVictory6.setTranslateX(500);
        lbVictory6.setTranslateY(400);
        lbVictoriy7.setTranslateX(500);
        lbVictoriy7.setTranslateY(440);
    }

    public void controlButtons() {

        bSelecChar = new Button("Seleccion de Personajes");
        bExit = new Button("Salir");

        bSelecChar.setTranslateX(500);
        bSelecChar.setTranslateY(580);

        bExit.setTranslateX(550);
        bExit.setTranslateY(650);

        bExit.setCursor(Cursor.HAND);
        bSelecChar.setCursor(Cursor.HAND);
    }

    public void eventExit() {

        bExit.setOnAction((event) -> {
            Platform.exit();

        });
    }

    public void eventViewMain() {
        bSelecChar.setOnAction((event) -> {
            window4.getChildren().add(winMain.showWinMain());
        });
    }
}
