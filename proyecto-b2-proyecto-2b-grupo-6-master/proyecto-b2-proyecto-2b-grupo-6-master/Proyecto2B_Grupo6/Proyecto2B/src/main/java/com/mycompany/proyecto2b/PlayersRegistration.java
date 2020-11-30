package com.mycompany.proyecto2b;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayersRegistration {

    private final ArrayList<Player> players;

    public PlayersRegistration() {

        this.players = new ArrayList<>();
        playersRegistration();

    }

    public boolean add(Player player) {

        if (this.players.contains(player)) {
            return false;
        }

        this.players.add(player);
        return true;

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void playersRegistration() {
        
        try (Scanner scanner = new Scanner(Paths.get("jugadores.txt"))) {
            while (scanner.hasNextLine()) {
                String lineas = scanner.nextLine();

                String[] partes = lineas.split(",");
                String namePlayer = partes[0];
                String lastName = partes[1];
                int identificationCard = Integer.valueOf(partes[2]);
                String user = partes[3];
                int victories=Integer.valueOf(partes[4]);
                
                players.add(new Player(namePlayer, lastName, identificationCard, user,victories));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//Funcion de la creacion de jugador
    public void createPlayer(String name, String lastName, int identificationCard, String user) {

        if (!existingUser(identificationCard)) {

            try {
                try (FileWriter fichero = new FileWriter("jugadores.txt",true)) {
                    fichero.write("\n" + name + "," + lastName + "," + identificationCard + "," + user);
                    fichero.close();
                }
            } catch (IOException io) {
                System.out.println("Error en crear"+io.getMessage());
            }

        }
    }

    public Player searchPlayer(int identificationCard) {
        for (Player player : players) {
            if (identificationCard == player.getIdentificationCard()) {
                return player;
            }

        }
        return null;
    }

    public boolean existingUser(int identificationCard) {
        for (Player player : players) {
            if (identificationCard == player.getIdentificationCard()) {
                return true;
            }
        }
        return false;
    }
    
       
    
    public Player searchPlayer(String name) {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                return player;
            }

        }
        return null;
   
    }

}
