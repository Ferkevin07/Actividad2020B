package com.mycompany.proyecto2b;

import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class PlayersRegView {

    Image imagen6;
    ImageView imagenView6;
    ChoiceBox<Integer> chbIdentificationCard;
    PlayersRegistration regPlayers;
    TextField tfName;
    TextField tfLastName;
    TextField tfIdentificationCard;
    TextField tfUser;
    Label lbName;
    Label lbLastName;
    Label lbIdentificationCard;
    Label lbUser;
    Button bCreate;
    Button bDelete;
    Button bModify;
    Button bSelecChar;
    TableView<Player> table;

    Pane window2 = new Pane();
    ViewMain venPrincipal = new ViewMain();
    
    
    public Parent showWindow() {

        regPlayers = new PlayersRegistration();

        window2.setMinSize(350, 250);

        controlImagenes();
        //imagenView6.fitWidthProperty().bind(ventana.widthProperty());
        controlChoiceBox();

        regPlayers.getPlayers().forEach(jugad -> {
            chbIdentificationCard.getItems().add(jugad.getIdentificationCard());
        });
        controlLabel();
        controlTexField();
        controlBotones();
        controlTable();

        eventShowPlayTable();
        eventCreateUs();
        eventViewMain();

        window2.getChildren().addAll(imagenView6, chbIdentificationCard, lbName, lbLastName, lbIdentificationCard, lbUser, tfName, tfLastName, tfIdentificationCard, tfUser, bCreate, bDelete, bModify, bSelecChar, table);

        return window2;
    }

    public void cleanFields(TextField tfName, TextField tfLastName, TextField tfIdentificationCard, TextField tfUser) {
        tfName.clear();
        tfLastName.clear();
        tfIdentificationCard.clear();
        tfUser.clear();
    }

    public void controlImagenes() {

        imagen6 = new Image("file:fondo5.jpg");
        imagenView6 = new ImageView(imagen6);
        imagenView6.setPreserveRatio(true);
    }

    public void controlChoiceBox() {
        chbIdentificationCard = new ChoiceBox<>();

        chbIdentificationCard.setScaleX(2.3);
        chbIdentificationCard.setScaleY(1);

        chbIdentificationCard.setTranslateX(785);
        chbIdentificationCard.setTranslateY(40);
    }

    public void controlLabel() {

        lbName = new Label("Nombre: ");
        lbLastName = new Label("Apellido: ");
        lbIdentificationCard = new Label("Cédula: ");
        lbUser = new Label("Usuario: ");

        lbName.setScaleX(2);
        lbName.setScaleY(2);
        lbLastName.setScaleX(2);
        lbLastName.setScaleY(2);
        lbIdentificationCard.setScaleX(2);
        lbIdentificationCard.setScaleY(2);
        lbUser.setScaleX(2);
        lbUser.setScaleY(2);

        lbName.setTranslateX(750);
        lbName.setTranslateY(90);
        lbLastName.setTranslateX(750);
        lbLastName.setTranslateY(150);
        lbIdentificationCard.setTranslateX(750);
        lbIdentificationCard.setTranslateY(210);
        lbUser.setTranslateX(750);
        lbUser.setTranslateY(270);
    }

    public void controlTexField() {

        tfName = new TextField();
        tfLastName = new TextField();
        tfIdentificationCard = new TextField();
        tfUser = new TextField();

        tfName.setScaleX(1.5);
        tfName.setScaleY(1);
        tfLastName.setScaleX(1.5);
        tfLastName.setScaleY(1);
        tfIdentificationCard.setScaleX(1.5);
        tfIdentificationCard.setScaleY(1);
        tfUser.setScaleX(1.5);
        tfUser.setScaleY(1);

        tfName.setTranslateX(760);
        tfName.setTranslateY(115);
        tfLastName.setTranslateX(760);
        tfLastName.setTranslateY(175);
        tfIdentificationCard.setTranslateX(760);
        tfIdentificationCard.setTranslateY(235);
        tfUser.setTranslateX(760);
        tfUser.setTranslateY(295);
    }

    public void controlBotones() {

        bCreate = new Button("Crear");
        bDelete = new Button("Eliminar");
        bModify = new Button("Modificar");
        bSelecChar = new Button("Ir a Selecionar \n Personajes ");

        bCreate.setScaleX(2.7);
        bCreate.setScaleY(2);
        bDelete.setScaleX(2.1);
        bDelete.setScaleY(2);
        bModify.setScaleX(1.85);
        bModify.setScaleY(2);
        bSelecChar.setScaleX(1.5);
        bSelecChar.setScaleY(1.5);

        bCreate.setTranslateX(810);
        bCreate.setTranslateY(360);
        bDelete.setTranslateX(805);
        bDelete.setTranslateY(420);
        bModify.setTranslateX(800);
        bModify.setTranslateY(480);
        bSelecChar.setTranslateX(540);
        bSelecChar.setTranslateY(580);

        bCreate.setCursor(Cursor.HAND);
        bDelete.setCursor(Cursor.HAND);
        bModify.setCursor(Cursor.HAND);
        bSelecChar.setCursor(Cursor.HAND);
    }

    public void controlTable() {

        table = new TableView();
        TableColumn<Player, Integer> colId = new TableColumn<>("id");
        TableColumn<Player, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Player, String> colApellido = new TableColumn<>("Apellido");
        TableColumn<Player, Integer> colCedula = new TableColumn<>("Cedula");
        TableColumn<Player, String> colUsuario = new TableColumn<>("Usuario");
        TableColumn<Player, Integer> colVitorias = new TableColumn<>("Victorias");

        table.setScaleX(1);
        table.setScaleY(1.2);
        table.setTranslateX(230);
        table.setTranslateY(80);
        table.getColumns().addAll(colId, colNombre, colApellido, colCedula, colUsuario, colVitorias);
        
 


    }

    public void eventShowPlayTable() {

        chbIdentificationCard.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observableValue, Number number, Number number2) -> {
            int cedula = chbIdentificationCard.getItems().get((Integer) number2);

            regPlayers.searchPlayer(cedula);
            tfName.setText((regPlayers.searchPlayer(cedula)).getName());
            tfLastName.setText((regPlayers.searchPlayer(cedula)).getLastName());
            tfIdentificationCard.setText(String.valueOf((regPlayers.searchPlayer(cedula)).getIdentificationCard()));
            tfUser.setText((regPlayers.searchPlayer(cedula)).getUser());

        });
    }

    public void eventCreateUs() {
        bCreate.setOnAction((event) -> {

            if (tfName.getText().isEmpty() || tfLastName.getText().isEmpty() || tfUser.getText().isEmpty() || tfIdentificationCard.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Ingrese todos los campos!");

            }

            int IdentificationCard = Integer.valueOf(tfIdentificationCard.getText());
            String name = tfName.getText();
            String lastName = tfLastName.getText();
            String user = tfUser.getText();

            if (regPlayers.existingUser(IdentificationCard)) {
                JOptionPane.showMessageDialog(null, "Usuario existente");

            }

            if (!tfName.getText().isEmpty() && !tfLastName.getText().isEmpty() && !tfUser.getText().isEmpty() && !tfIdentificationCard.getText().isEmpty() && !regPlayers.existingUser(IdentificationCard)) {
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente!");
            }

            regPlayers.createPlayer(name, lastName, IdentificationCard, user);
            cleanFields(tfName, tfLastName, tfIdentificationCard, tfUser);
            
            javafx.scene.media.AudioClip sound = new javafx.scene.media.AudioClip ("file:button-49.wav");
            sound.play();

        });
    }

    public void eventViewMain() {
        bSelecChar.setOnAction((event) -> {
            window2.getChildren().add(venPrincipal.showWinMain());

        });
    }

}
