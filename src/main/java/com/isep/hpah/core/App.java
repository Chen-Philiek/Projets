package com.isep.hpah.core;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        App.introduction();
        App.Game();

    }


    private static void Game() {
        Scanner scanner = new Scanner(System.in);
        // Demander le nom du joueur
        System.out.print("Entrez votre nom: ");
        String playerName = scanner.nextLine();
        Wizard wizard = new Wizard();
        wizard.setName(playerName);
        wizard.setHouse(House.getHouse());
        wizard.setWand(Wand.getWand());
        wizard.setPet(Pet.randomPet());
        wizard.setKnownSpells(new ArrayList<>());
        wizard.setPotions(new ArrayList<>());
        Wand.randomWandSize();
        wizard.setHealth(Wizard.randomHealth());
        wizard.setHealth(Wizard.MaxHealth());
        Potion.ListPotion(wizard);
        Spell.listSpells(wizard);
        AbstractEnemy enemy = new Enemy("Troll", 100,40,EnemyType.TROLL);
        AbstractEnemy boss = new Boss("Voldemort",20,60,BossLevel.VOLEDEMORT);
        Combat combat = new Combat(enemy, boss);
        App.ChatperOne();
        // Lancer le combat
        combat.ennemyappear();
        combat.fight(wizard);

    }

    private static void introduction() {
        System.out.println("Bienvenue dans le monde de Harry Potter. \nJeune sorcier ou sorcière, avant de démarrer l'aventure, voici quelques éléments à savoir : ");
        System.out.println("• Les potions sont plus efficaces pour les membres de Hufflepuff.\n" +
                "• Les sorts font plus de dégâts pour les membres de Slytherin.\n" +
                "• Les sorciers de Gryffindor sont plus résistants aux dégâts.\n" +
                "• Les sorciers de Ravenclaw sont plus précis.");
        System.out.println("Vos stats sont générés aléatoirement. Cependant, vous pourrez faire des choix pour tout ce qui est potion et sortillège");
        Wait.wait(2000);
    }
    private static void ChatperOne(){
        System.out.println("<----------Chapitre 1----------->\n");
        System.out.println("The Philosopher's Stone\n");
        System.out.println("Vous arrivez devant le donjon et vous sentez une odeur de durian sur vos mains et vous décidez d'aller au toilette...\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît ! Pour le terasser, il vous faut jeter le bon sort !\n");
        Wait.wait(2000);
    }
    }



