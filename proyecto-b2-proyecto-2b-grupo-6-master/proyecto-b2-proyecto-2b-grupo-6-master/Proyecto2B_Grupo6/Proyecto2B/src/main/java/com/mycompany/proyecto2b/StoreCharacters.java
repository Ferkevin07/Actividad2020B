package com.mycompany.proyecto2b;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreCharacters{

    private final ArrayList<Character> characters;
    public StoreCharacters() {
        this.characters = new ArrayList<>();
        registerCharacters();
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void registerCharacters() {
        try (Scanner scanner = new Scanner(Paths.get("personajes.txt"))) {
            while (scanner.hasNextLine()) {
                String lines = scanner.nextLine();

                String[] parts = lines.split(",");
                String nameCharacters = parts[0];
                String attack = parts[1];
                String finalAttack = parts[2];
                int life = Integer.valueOf(parts[3]);
                int stamina = Integer.valueOf(parts[4]);
                String kind = parts[5];

                characters.add(new Character(nameCharacters, attack, finalAttack, life, stamina, kind));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Character searchCharacter(String nameChar) {
        for (Character character : characters) {
            if (nameChar.equals(character.getName())) {
                return character;
            }

        }
        return null;
    }

}
