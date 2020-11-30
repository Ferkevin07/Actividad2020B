package com.mycompany.proyecto2b;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

public class BattleView extends StoreCharacters {

    Image imagen7;
    ImageView imagenView7;

    Label lbName1;
    Label lbName2;
    Label lbNameChar1;
    Label lbNameChar2;
    Label lbLife1;
    Label lbStamina1;
    Label lbLife2;
    Label lbStamina2;
    Label lbLifeJ1;
    Label lbStaminaJ1;
    Label lbLifeJ2;
    Label lbStaminaJ2;

    Button bAttack1;
    Button bAttack2;
    Button bDefense1;
    Button bDefense2;
    Button bFinalAttack1;
    Button bFinalAttack2;
    Button bHeal1;
    Button bHeal2;
    Button bStatistics;

    private final ArrayList<String> namePlay = new ArrayList<>();
    private final ArrayList<String> nameChar = new ArrayList<>();
    private boolean turn = true;
    private int countTurn1;
    private int countTurn2;
    private boolean turnDefense;
    private boolean option;
    StoreCharacters almacPersonajes;
    PlayersRegistration regPlayers;
    Pane ventana3;
   
    TextArea txtArInformation;

    public BattleView() {
        almacPersonajes = new StoreCharacters();
        regPlayers= new PlayersRegistration();
        
        turnDefense=false;
        this.option=false;
    }

    public Parent showWindow() {
        
        ViewStatistics viewStatistics;
        //endBattle(0);
        this.countTurn1 = 0;
        this.countTurn2 = 0;

      
        viewStatistics = new ViewStatistics();
        ventana3 = new Pane();
        ventana3.setMinSize(3000, 2000);

        controlImages();
        controlLabels();
        controlBotones();
        txtArInformation = new TextArea();
        txtArInformation.setTranslateX(30);
        txtArInformation.setTranslateY(520);

        eventAttackP1();
        eventFinalAttackP1();
        eventDefenseP1();
        eventHealP1();

        eventAttackP2();
        eventFinalAttackP2();
        eventDefenseP2();
        eventHealP2();

        changeTurn(turn);

        ventana3.getChildren().addAll(imagenView7, txtArInformation, bAttack1, bAttack2, bFinalAttack1, bFinalAttack2, bHeal1, bHeal2, bDefense1, bDefense2, lbStamina1, lbStamina2, lbNameChar1, lbNameChar2, lbName1, lbName2, lbLife1, lbLife2, lbStaminaJ1, lbStaminaJ2, lbLifeJ1, lbLifeJ2, bStatistics);

            bStatistics.setOnAction((event) -> {
            ventana3.getChildren().add(viewStatistics.showView());
            
        });
        return ventana3;
    }
//Funcion para controlar las imagenes
    public void controlImages() {

        imagen7 = new Image("file:fondogif2.gif");
        imagenView7 = new ImageView(imagen7);
        imagenView7.setFitHeight(2000);
        imagenView7.setFitWidth(1800);
        imagenView7.setPreserveRatio(true);
    }

    public void controlLabels() {

        lbName1 = new Label();
        lbName1.setText(namePlay.get(0));
        lbName2 = new Label(namePlay.get(1));
        lbNameChar1 = new Label(nameChar.get(0));
        lbNameChar2 = new Label(nameChar.get(1));

        lbLife1 = new Label("Vida:");
        lbStamina1 = new Label("Estamina");
        lbLife2 = new Label("Vida");
        lbStamina2 = new Label("Estamina");

        int vidaJ1 = (searchCharacter((nameChar.get(0)))).getLife();
        int vidaJ2 = (searchCharacter((nameChar.get(1)))).getLife();
        int estaminaaJ1 = (searchCharacter((nameChar.get(0)))).getStamina();
        int estaminaJ2 = (searchCharacter((nameChar.get(1)))).getStamina();

        lbLifeJ1 = new Label(String.valueOf(vidaJ1));
        lbStaminaJ1 = new Label(String.valueOf(estaminaaJ1));
        lbLifeJ2 = new Label(String.valueOf(vidaJ2));
        lbStaminaJ2 = new Label(String.valueOf(estaminaJ2));

        lbName1.setScaleX(2.5);
        lbName1.setScaleY(2);
        lbName2.setScaleX(2.5);
        lbName2.setScaleY(2);
        lbNameChar1.setScaleX(2.5);
        lbNameChar1.setScaleY(2);
        lbNameChar2.setScaleX(2.5);
        lbNameChar2.setScaleY(2);
        lbLife1.setScaleX(2);
        lbLife1.setScaleY(1);
        lbLife2.setScaleX(2);
        lbLife2.setScaleY(1);
        lbStamina1.setScaleX(2);
        lbStamina1.setScaleY(1);
        lbStamina2.setScaleX(2);
        lbStamina2.setScaleY(1);

        lbName1.setTextFill(Color.web("#ffffff", 0.8));
        lbName2.setTextFill(Color.web("#ffffff", 0.8));
        lbNameChar1.setTextFill(Color.web("#ffffff", 0.8));
        lbNameChar2.setTextFill(Color.web("#ffffff", 0.8));
        lbLife1.setTextFill(Color.web("#ffffff", 0.8));
        lbLife2.setTextFill(Color.web("#ffffff", 0.8));
        lbStamina1.setTextFill(Color.web("#ffffff", 0.8));
        lbStamina2.setTextFill(Color.web("#ffffff", 0.8));

        lbName1.setTranslateX(80);
        lbName1.setTranslateY(40);
        lbName2.setTranslateX(1100);
        lbName2.setTranslateY(40);
        lbNameChar1.setTranslateX(60);
        lbNameChar1.setTranslateY(100);
        lbNameChar2.setTranslateX(1100);
        lbNameChar2.setTranslateY(100);
        lbLife1.setTranslateX(60);
        lbLife1.setTranslateY(140);
        lbLife2.setTranslateX(1100);
        lbLife2.setTranslateY(140);
        lbStamina1.setTranslateX(60);
        lbStamina1.setTranslateY(180);
        lbStamina2.setTranslateX(1100);
        lbStamina2.setTranslateY(180);

        lbLifeJ1.setTextFill(Color.web("#ffffff", 0.8));
        lbLifeJ2.setTextFill(Color.web("#ffffff", 0.8));
        lbStaminaJ1.setTextFill(Color.web("#ffffff", 0.8));
        lbStaminaJ2.setTextFill(Color.web("#ffffff", 0.8));

        lbLifeJ1.setScaleX(2);
        lbLifeJ1.setScaleY(1);
        lbLifeJ2.setScaleX(2);
        lbLifeJ2.setScaleY(1);
        lbStaminaJ1.setScaleX(2);
        lbStaminaJ1.setScaleY(1);
        lbStaminaJ2.setScaleX(2);
        lbStaminaJ2.setScaleY(1);

        lbLifeJ1.setTranslateX(180);
        lbLifeJ1.setTranslateY(140);
        lbLifeJ2.setTranslateX(1200);
        lbLifeJ2.setTranslateY(140);
        lbStaminaJ1.setTranslateX(180);
        lbStaminaJ1.setTranslateY(180);
        lbStaminaJ2.setTranslateX(1200);
        lbStaminaJ2.setTranslateY(180);

    }

    public void controlBotones() {

        bAttack1 = new Button("Ataque");
        bAttack2 = new Button("Ataque");
        bDefense1 = new Button("Defensa");
        bDefense2 = new Button("Defensa");
        bFinalAttack1 = new Button("Ataque Final");
        bFinalAttack2 = new Button("Ataque Final");
        bHeal1 = new Button("Curar");
        bHeal2 = new Button("Curar");
        bStatistics = new Button("Estadisticas");

        bAttack1.setTranslateX(30);
        bAttack1.setTranslateY(400);
        bAttack2.setTranslateX(1100);
        bAttack2.setTranslateY(400);
        bFinalAttack1.setTranslateX(120);
        bFinalAttack1.setTranslateY(400);
        bFinalAttack2.setTranslateX(1190);
        bFinalAttack2.setTranslateY(400);
        bDefense1.setTranslateX(30);
        bDefense1.setTranslateY(450);
        bDefense2.setTranslateX(1100);
        bDefense2.setTranslateY(450);
        bHeal1.setTranslateX(120);
        bHeal1.setTranslateY(450);
        bHeal2.setTranslateX(1190);
        bHeal2.setTranslateY(450);
        bStatistics.setTranslateX(650);
        bStatistics.setTranslateY(650);

        bAttack1.setCursor(Cursor.HAND);
        bAttack2.setCursor(Cursor.HAND);
        bFinalAttack1.setCursor(Cursor.HAND);
        bFinalAttack2.setCursor(Cursor.HAND);
        bHeal1.setCursor(Cursor.HAND);
        bHeal2.setCursor(Cursor.HAND);
        bDefense1.setCursor(Cursor.HAND);
        bDefense2.setCursor(Cursor.HAND);
        bStatistics.setCursor(Cursor.HAND);

    }

    public void addBattle(String namePlay, String nameChar) {

        this.namePlay.add(namePlay);
        this.nameChar.add(nameChar);
    }
    
    

    public void eventAttackP1() {

        bAttack1.setOnAction((event) -> {

            (searchCharacter((nameChar.get(0)))).atacarNormal();
            attackToOpponent(1, lbLifeJ2, 5);
            (searchCharacter((nameChar.get(0)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(0)))).getStamina();

            validationStamina0(lbStaminaJ1, stamina, 0);

            String information=(searchCharacter((nameChar.get(0)))).getAttack();
            logActivities("Ataque "+information, 0);
            lbStaminaJ1.setText(String.valueOf(stamina));

            
            disableButtons(true);
            
            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip("file:button-49.wav");
            sound.play();

        });
    }

    public void eventFinalAttackP1() {
        bFinalAttack1.setOnAction((event) -> {
            (searchCharacter((nameChar.get(0)))).atacarFuerte();
            attackToOpponent(1, lbLifeJ2, 50);
            (searchCharacter((nameChar.get(0)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(0)))).getStamina();
            
            String information=(searchCharacter((nameChar.get(0)))).getFinalAttack();
            logActivities("Ataque final "+information, 0);
            lbStaminaJ1.setText(String.valueOf(stamina));

            disableButtons(true);

            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip("file:button-49.wav");
            sound.play();

        });
    }

    public void eventDefenseP1() {

        
        bDefense1.setOnAction((event) -> {
            option=true;
            
            
            (searchCharacter((nameChar.get(0)))).defender();

            (searchCharacter((nameChar.get(0)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(0)))).getStamina();
            
            logActivities("Defensa ", 0);
            lbStaminaJ1.setText(String.valueOf(stamina));

            disableButtons(true);

            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip("file:button-49.wav");
            sound.play();
        });
    }

    public void eventHealP1() {
        bHeal1.setOnAction((event) -> {

            (searchCharacter((nameChar.get(0)))).curar();
            (searchCharacter((nameChar.get(0)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(0)))).getStamina();
            
            logActivities("Curacion ", 0);
            lbStaminaJ1.setText(String.valueOf(stamina));

            int life = (searchCharacter((nameChar.get(0)))).getLife();
            lbLifeJ1.setText(String.valueOf(life));

            disableButtons(true);

        });
    }

    public void eventAttackP2() {

        bAttack2.setOnAction((event) -> {

            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip("file:button-49.wav");
            sound.play();

            (searchCharacter((nameChar.get(1)))).atacarNormal();
            attackToOpponent(0, lbLifeJ1, 5);
            (searchCharacter((nameChar.get(1)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(1)))).getStamina();

            validationStamina0(lbStaminaJ2, stamina, 1);

            String information=(searchCharacter((nameChar.get(1)))).getAttack();
            logActivities("Ataque "+information, 1);
            lbStaminaJ2.setText(String.valueOf(stamina));
            disableButtons(false);

        });
    }

    public void eventFinalAttackP2() {
        bFinalAttack2.setOnAction((event) -> {

            (searchCharacter((nameChar.get(1)))).atacarFuerte();
            attackToOpponent(0, lbLifeJ1, 50);
            (searchCharacter((nameChar.get(1)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(1)))).getStamina();
            String information=(searchCharacter((nameChar.get(1)))).getFinalAttack();
            logActivities("Ataque final "+information, 1);
            lbStaminaJ2.setText(String.valueOf(stamina));

            disableButtons(false);

            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip("file:button-49.wav");
            sound.play();

        });
    }

    public void eventDefenseP2() {
        bDefense2.setOnAction((event) -> {
            option=true;
            
            (searchCharacter((nameChar.get(1)))).defender();
            (searchCharacter((nameChar.get(1)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(1)))).getStamina();
            logActivities("Defensa ", 1);
            lbStaminaJ2.setText(String.valueOf(stamina));

            disableButtons(false);

            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip("file:button-49.wav");
            sound.play();
        });
    }

    public void eventHealP2() {

        bHeal2.setOnAction((event) -> {
            (searchCharacter((nameChar.get(1)))).curar();
            (searchCharacter((nameChar.get(1)))).increaseStamina();

            int stamina = (searchCharacter((nameChar.get(1)))).getStamina();
            logActivities("Curacion ", 1);
            lbStaminaJ2.setText(String.valueOf(stamina));

            int life = (searchCharacter((nameChar.get(1)))).getLife();
            lbLifeJ2.setText(String.valueOf(life));

            disableButtons(false);

            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip("file:button-49.wav");
            sound.play();
        });
    }

    public void changeTurn(boolean turn) {

        if (turn == true) {

            

            bAttack2.setDisable(true);
            bFinalAttack2.setDisable(true);
            bDefense2.setDisable(true);
            bHeal2.setDisable(true);
        } else {

            
            
            bAttack1.setDisable(true);
            bFinalAttack1.setDisable(true);
            bDefense1.setDisable(true);
            bHeal1.setDisable(true);

        }

    }

    public void disableButtons(boolean turn) {

        if (turn == false) {

            int stamina = (searchCharacter((nameChar.get(0)))).getStamina();

            changeTurn(true);

            if (stamina >= (searchCharacter((nameChar.get(0)))).getPercentAttack()) {
                bAttack1.setDisable(false);

            } else {

                bAttack1.setDisable(true);

            }

            if (stamina >= (searchCharacter((nameChar.get(0)))).getPercentFinalAttack()) {
                bFinalAttack1.setDisable(false);
            } else {
                bFinalAttack1.setDisable(true);
            }

            if (stamina >= (searchCharacter((nameChar.get(0)))).getPercentDefense()) {
                bDefense1.setDisable(false);
            } else {
                bDefense1.setDisable(true);
            }

            if (stamina >= (searchCharacter((nameChar.get(0)))).getPercentHeal()) {
                bHeal1.setDisable(false);
            } else {
                bHeal1.setDisable(true);
            }
        } else {
            int stamina = (searchCharacter((nameChar.get(1)))).getStamina();

            changeTurn(false);

            if (stamina >= (searchCharacter((nameChar.get(1)))).getPercentAttack()) {
                bAttack2.setDisable(false);

            } else {
                bAttack2.setDisable(true);
            }

            if (stamina >= (searchCharacter((nameChar.get(1)))).getPercentFinalAttack()) {
                bFinalAttack2.setDisable(false);
            } else {
                bFinalAttack2.setDisable(true);
            }

            if (stamina >= (searchCharacter((nameChar.get(1)))).getPercentDefense()) {
                bDefense2.setDisable(false);
            } else {
                bDefense2.setDisable(true);
            }

            if (stamina >= (searchCharacter((nameChar.get(1)))).getPercentHeal()) {
                bHeal2.setDisable(false);
            } else {
                bHeal2.setDisable(true);
            }

        }

    }

    public void validationStamina0(Label lbEstaminaP, int stamina, int indice) {

        if (stamina < 0) {

            searchCharacter((nameChar.get(indice))).setStamina(0);
            lbEstaminaP.setText("0");

        }
    }

    public void attackToOpponent(int index, Label lbLife, int percent ) {
        
        (searchCharacter((nameChar.get(index)))).decreaseLife(percent,false);

        int life = (searchCharacter((nameChar.get(index)))).getLife();
        lbLife.setText(String.valueOf(life));
        
        if(life==0){
           endBattle(index);
           //ventana3.getChildren().add(viewStatistics.mostrarVentana());
                    
        }

    }
    public void endBattle(int index){
        
        
        int win=0;
        
        if(index==0){
            
            win=1;
   
        }else{
            win=0;
        }
        String name=(searchCharacter((namePlay.get(win))).getName());
        regPlayers.searchPlayer(name).addVictories();
        updateVictories();
    }
    public void updateVictories(){
        
        
            try {
                FileWriter fichero = new FileWriter("jugadores.txt",false);
                for (Player player : regPlayers.getPlayers()){
                    fichero.write("\n" + player.getName() + "," + player.getLastName() + "," + player.getIdentificationCard() + "," + player.getUser()+","+player.getVictories());
                    fichero.close();
                }
                
                
            } catch (IOException io) {
                System.out.println("Error en actualizar victorias"+io.getMessage());
            }

    }
    public void logActivities(String information, int index){
        
        txtArInformation.appendText("Player"+(index+1)+": utilizo "+ information+"\n");
    }

    

}
