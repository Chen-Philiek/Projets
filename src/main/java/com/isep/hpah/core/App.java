package com.isep.hpah.core;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Demander le nom du joueur
        System.out.print("Entrez votre nom: ");
        String playerName = scanner.nextLine();

        // Générer un animal aléatoire
        House.randomHouse();
        Pet.randomPet();
        Wand.Tot();
        Character.Tota();
        Potion.ListPotion();
        Spell.listSpells();







    }
}
