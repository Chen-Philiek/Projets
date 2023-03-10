package com.isep.hpah.core;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();

        // Attribuer une maison au hasard
        House[] houses = { new House("Gryffondor"), new House("Serpentard"), new House("Poufsouffle"),
                new House("Serdaigle") };
        House maison = houses[random.nextInt(houses.length)];

        // Attribuer des points de vie, une attaque et une défense au hasard
        int pointsDeVie = random.nextInt(101) + 100;
        int attaque = random.nextInt(21) + 10;

        // Attribuer une baguette magique au hasard
        Core[] cores = { new Core("Phoenix"), new Core("Dragon"), new Core("Licorne"), new Core("Veaudricoeur") };
        Core noyau = cores[random.nextInt(cores.length)];
        int tailleBaguette = random.nextInt(11) + 20;
        Wand wand = new Wand(noyau, tailleBaguette);

        // Créer un nouveau sorcier avec les attributs générés aléatoirement
        Wizard sorcier = new Wizard(nom, maison, pointsDeVie, attaque, wand);

        // Afficher les informations du sorcier
        System.out.println("Bienvenue " + sorcier.getName() + " de la maison " + sorcier.getHouse().getName());
        System.out.println("Points de vie : " + sorcier.getHealth());
        System.out.println("Attaque : " + sorcier.getDamage());
        System.out.println("Baguette magique : " + sorcier.getWand().getCore().getName() + " de taille " + sorcier.getWand().getSize());
    }
}
