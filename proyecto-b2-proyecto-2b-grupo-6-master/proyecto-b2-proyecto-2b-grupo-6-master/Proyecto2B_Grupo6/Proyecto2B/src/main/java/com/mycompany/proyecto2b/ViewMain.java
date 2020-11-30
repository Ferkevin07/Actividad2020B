package com.mycompany.proyecto2b;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
//PROYECTO 2020B

public class ViewMain {

    private Image image1, image2, image3;
    private ImageView backgroundView, titleView, CharacterView;
    private ChoiceBox<String> chbCharacters, chbPlayers, chbPlayers2;
    private ArrayList<ImageView> imgCharacters;
    private ArrayList<ImageView> imgCharacters2;
    private Button bSelection1, bSelection2, bRegister, bStart;
    private BorderPane containerChar, containerChar2, containerChar3;
    private Pane containerGen;
    private boolean turn;
    private int index = 0;
    PlayersRegistration regPlayers;
    StoreCharacters regCharacters;
    
    BattleView vistaBatalla = new BattleView();
   

    public Parent showWinMain() {

        javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip ("file:NarutoOpening.wav");
        sound.play();
        turn = true;

        imgCharacters = new ArrayList<>();
        imgCharacters2 = new ArrayList<>();
        controlImages(imgCharacters, imgCharacters2);

        containerChar = new BorderPane();
        containerChar2 = new BorderPane();
        containerChar3 = new BorderPane();
        containerGen = new Pane();
        containerGen.setMinSize(350, 250);
        controlChoiceBox();
        
        //AGREGAR INFORMACION
        //Agregar la informacion de Jugadores al choicebox
        regPlayers = new PlayersRegistration();
        regCharacters = new StoreCharacters();

        addChoiceBox(regPlayers, regCharacters);

        controlButtons();

        //Eventos     
        PlayersRegView vistaReg = new PlayersRegView();

        eventChangeView(vistaReg, vistaBatalla);
        eventChangeImages();
        eventSelecCharacter();

        containerGen.getChildren().addAll(backgroundView, titleView, CharacterView, bRegister, containerChar2, containerChar3, containerChar,
                bSelection1, bSelection2, bStart, chbCharacters, chbPlayers, chbPlayers2);

        return containerGen;
        
        
    }

    public void controlImages(ArrayList imgCharacters, ArrayList imgCharacters2) {

        image2 = new Image("file:tittle.png");
        titleView = new ImageView(image2);
        titleView.setFitHeight(220);
        titleView.setFitWidth(570);
        titleView.setTranslateX(460);
        titleView.setTranslateY(20);

        image3 = new Image("file:personaje1.png");
        CharacterView = new ImageView(image3);
        CharacterView.setPreserveRatio(true);
        CharacterView.setFitHeight(450);
        CharacterView.setFitWidth(250);

        CharacterView.setTranslateX(450);
        CharacterView.setTranslateY(200);

        image1 = new Image("file:fondoprincipal.jpg");
        backgroundView = new ImageView(image1);
        backgroundView.setPreserveRatio(true);

        Image imgNaruto = new Image("file:naruto.png");
        ImageView narutoView = new ImageView(imgNaruto);
        narutoView.setPreserveRatio(true);
        narutoView.setFitHeight(470);
        narutoView.setFitWidth(270);
        narutoView.setTranslateX(590);
        narutoView.setTranslateY(250);

        Image imgNaruto2 = new Image("file:narutoC.png");

        ImageView narutoView2 = new ImageView(imgNaruto2);
        narutoView2.setPreserveRatio(true);
        narutoView2.setFitHeight(400);
        narutoView2.setFitWidth(230);
        narutoView2.setTranslateX(150);
        narutoView2.setTranslateY(130);

        Image imgSasuke = new Image("file:sasuke.png");
        ImageView sasukeView = new ImageView(imgSasuke);
        sasukeView.setImage(imgSasuke);
        sasukeView.setPreserveRatio(true);
        sasukeView.setFitHeight(385);
        sasukeView.setFitWidth(185);
        sasukeView.setTranslateX(640);
        sasukeView.setTranslateY(275);

        Image imgSasuke2 = new Image("file:sasukeC.png");

        ImageView sasukeView2 = new ImageView(imgSasuke2);
        sasukeView2.setPreserveRatio(true);
        sasukeView2.setFitHeight(400);
        sasukeView2.setFitWidth(230);
        sasukeView2.setTranslateX(150);
        sasukeView2.setTranslateY(130);

        Image imgSakura = new Image("file:sakura.png");
        ImageView sakuraView = new ImageView(imgSakura);
        sakuraView.setImage(imgSakura);
        sakuraView.setPreserveRatio(true);
        sakuraView.setFitHeight(430);
        sakuraView.setFitWidth(220);
        sakuraView.setTranslateX(620);
        sakuraView.setTranslateY(290);

        Image imgSakura2 = new Image("file:sakuraC.png");

        ImageView sakuraView2 = new ImageView(imgSakura2);
        sakuraView2.setPreserveRatio(true);
        sakuraView2.setFitHeight(400);
        sakuraView2.setFitWidth(230);
        sakuraView2.setTranslateX(200);
        sakuraView2.setTranslateY(120);

        Image imgKakashi = new Image("file:kakashi.png");
        ImageView kakashiView = new ImageView(imgKakashi);
        kakashiView.setImage(imgKakashi);
        kakashiView.setPreserveRatio(true);
        kakashiView.setFitHeight(395);
        kakashiView.setFitWidth(205);
        kakashiView.setTranslateX(620);
        kakashiView.setTranslateY(280);

        Image imgKakashi2 = new Image("file:kakashiC.png");

        ImageView kakashiView2 = new ImageView(imgKakashi2);
        kakashiView2.setPreserveRatio(true);
        kakashiView2.setFitHeight(400);
        kakashiView2.setFitWidth(230);
        kakashiView2.setTranslateX(150);
        kakashiView2.setTranslateY(130);

        imgCharacters.add(narutoView);
        imgCharacters.add(sasukeView);
        imgCharacters.add(kakashiView);
        imgCharacters.add(sakuraView);

        imgCharacters2.add(narutoView2);
        imgCharacters2.add(sasukeView2);
        imgCharacters2.add(kakashiView2);
        imgCharacters2.add(sakuraView2);

    }

    public void controlChoiceBox() {

        chbCharacters = new ChoiceBox<>();
        chbPlayers2 = new ChoiceBox<>();
        chbPlayers = new ChoiceBox<>();

        chbPlayers.setTranslateX(170);
        chbPlayers.setTranslateY(85);
        chbPlayers2.setTranslateX(1080);
        chbPlayers2.setTranslateY(85);
        chbCharacters.setTranslateX(680);
        chbCharacters.setTranslateY(250);

//        chbJugadores.setValue("Selecciona tu nombre");
//        chbJugadores2.setValue("Selecciona tu nombre");
//        chbPersonajes.setValue("Selecciona un personaje");

    }

    public void addChoiceBox(PlayersRegistration regJugadores, StoreCharacters regPersonajes) {

        regJugadores.getPlayers().forEach(jug -> {
            chbPlayers.getItems().add(jug.getName() + " " + jug.getLastName());
        });
        regJugadores.getPlayers().forEach(jugad -> {
            chbPlayers2.getItems().add(jugad.getName() + " " + jugad.getLastName());
        });

        regPersonajes.getCharacters().forEach(personaje -> {
            chbCharacters.getItems().add(personaje.getName());
        });


    }

    public void controlButtons() {

        bSelection1 = new Button("Seleccionar \n Jugador 1");
        bSelection2 = new Button("Seleccionar \n Jugador 2");
        bRegister = new Button("Registrar \n Jugador");
        bStart = new Button("Empezar");

        bSelection1.setTranslateX(200);
        bSelection1.setTranslateY(540);
        bSelection2.setTranslateX(1125);
        bSelection2.setTranslateY(530);
        bRegister.setTranslateX(690);
        bRegister.setTranslateY(580);
        bStart.setTranslateX(690);
        bStart.setTranslateY(650);//665

        bStart.setDisable(true);

        bRegister.setCursor(Cursor.HAND);
        bStart.setCursor(Cursor.HAND);
        bSelection1.setCursor(Cursor.HAND);
        bSelection2.setCursor(Cursor.HAND);

    }

    public void eventChangeView(PlayersRegView vistaReg, BattleView vistaBatalla) {

        bStart.setOnAction((event) -> {
            containerGen.getChildren().add(vistaBatalla.showWindow());
            
            AudioClip sound = new javafx.scene.media.AudioClip ("file:button-43.wav");
            sound.play();
            
        });
        bRegister.setOnAction((event) -> {
            containerGen.getChildren().add(vistaReg.showWindow());
            
            AudioClip sound = new javafx.scene.media.AudioClip ("file:button-43.wav");
            sound.play();
        });

    }

    public void eventChangeImages() {

        chbCharacters.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue ov, Object oldSelected, Object newSelected) {
                String selcPerson = chbCharacters.getItems().get((Integer) newSelected);
                containerChar.setLeft(imgCharacters.get((int) newSelected));

                index = (int) newSelected;

            }
            
            
        });
        

    }

    public void eventSelecCharacter() {

        if (turn == true) {
            bSelection1.setOnAction((event) -> {

                containerChar2.setLeft(imgCharacters2.get(index));
                vistaBatalla.addBattle(chbPlayers.getValue(), chbCharacters.getValue());
                
                AudioClip sound = new javafx.scene.media.AudioClip ("file:button-43.wav");
                sound.play();

            });
            turn = false;
        }
        if (turn == false) {

            bSelection2.setOnAction((event2) -> {

                containerChar3.setLayoutX(900);
                containerChar3.setRight(imgCharacters2.get(index));
                vistaBatalla.addBattle(chbPlayers2.getValue(), chbCharacters.getValue());

                bStart.setDisable(false);
                
                AudioClip sound = new javafx.scene.media.AudioClip ("file:button-43.wav");
                sound.play();

            });
        }

    }

}
