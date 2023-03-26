package com.isep.hpah.core;
import java.util.ArrayList;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        introduction();
        Wizard wizard = Game() ;
        wizard.ChapterOne();
    }


    private static Wizard Game() {
        Scanner scanner = new Scanner(System.in);
        // Demander le nom du joueur
        System.out.print("Entrez votre nom: ");
        String playerName = scanner.nextLine();
        Wizard wizard = new Wizard();
        wizard.setName(playerName);
        wizard.setHouse(House.getHouse(wizard));
        wizard.setWand(Wand.getWand());
        wizard.setPet(Pet.randomPet());
        wizard.setKnownSpells(new ArrayList<>());
        wizard.setPotions(new ArrayList<>());
        Wand.randomWandSize();
        wizard.setHealth(Wizard.randomHealth());
        wizard.setHealth(Wizard.MaxHealth());
        Potion.ListPotion(wizard);
        Spell.listSpells(wizard);
    return wizard;

    }

    private static void introduction() {
        System.out.println("Bienvenue dans le monde de Harry Potter. \nJeune sorcier ou sorcière, avant de démarrer l'aventure, voici quelques éléments à savoir : ");
        System.out.println("""
                • Les potions sont plus efficaces pour les membres de Hufflepuff.
                • Les sorts font plus de dégâts pour les membres de Slytherin.
                • Les sorciers de Gryffindor sont plus résistants aux dégâts.
                • Les sorciers de Ravenclaw sont plus précis.""");
        System.out.println("Vos stats sont générés aléatoirement. Cependant, vous pourrez faire des choix pour tout ce qui est potion et sortillège");
        Wait.wait(2000);
    }

    }



