package com.isep.hpah.core;
import java.util.Random;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Demander le nom du joueur
        System.out.print("Entrez votre nom: ");
        String playerName = scanner.nextLine();

        Wizard wizard = new Wizard(playerName, House.getHouse(), Wand.getWand());
        // Générer un animal aléatoire

        Wand.randomWandSize();
        Pet.randomPet();
        Character.Tota();
        Potion.ListPotion();
        Spell.listSpells();
        // Créer une instance de la classe Combat


        AbstractEnemy enemy = new Enemy("Orc", 10,40,EnemyType.ORC);
        AbstractEnemy boss = new Boss("Voldemort",20,60,BossLevel.VOLEDEMORT);
        Combat combat = new Combat(wizard, enemy, boss);

        // Lancer le combat
        combat.start();
    }
}
