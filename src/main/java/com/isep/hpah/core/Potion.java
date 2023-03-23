package com.isep.hpah.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Potion {
    private String name;
    private String description;
    public static List<Potion> potions= new ArrayList<>();

    public static Potion ListPotion(Wizard wizard) {
        Potion potion = new Potion();
        potion.setName(ChoosePotion(wizard));
        return potion;
    }

    private static String ChoosePotion(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a potion : \n 1.L \n 2.M\n 3.G");



        int numberPotion = scanner.nextInt();
        Potion ChoosedPotion =null;
        switch (numberPotion) {
            case 1:
                ChoosedPotion = Potion.L;
                break;
            case 2:
                ChoosedPotion = Potion.M;
                break;
            case 3:
                ChoosedPotion = Potion.G;
                break;
            default:
                ChoosePotion(wizard);
        }
        System.out.println("Vous venez d'obtenir la potion " + ChoosedPotion.getName());
        wizard.getPotions().add(ChoosedPotion);
        return ChoosedPotion.getName();
    }

    public double getHealAmount() {
        int heal = 0 ;
        switch (this.name) {
            case "L":
                heal = 50;
                break;
            case "M":
                heal = 30;
                break;
            case "G":
                heal = 20;
                break;

        }
        return heal;
    }
    public static final Potion L = new Potion("L", "T");
    public static final Potion M = new Potion("M", "C");
    public static final Potion G = new Potion("G", "C");
}
