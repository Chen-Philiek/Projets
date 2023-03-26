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
        System.out.println("Choose a potion : \n 1.Baume de Fierabras \n 2.Brise-Lame\n 3.Potion de Dittany ");



        int numberPotion = scanner.nextInt();
        Potion ChoosedPotion =null;
        switch (numberPotion) {
            case 1:
                ChoosedPotion = Potion.BaumedeFierabras;
                break;
            case 2:
                ChoosedPotion = Potion.BriseLame;
                break;
            case 3:
                ChoosedPotion = Potion.PotiondeDittany ;
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
            case "Baume de Fierabras":
                heal = 50;
                break;
            case "Brise-Lame":
                heal = 30;
                break;
            case "Potion de Dittany ":
                heal = 20;
                break;

        }
        return heal;
    }
    public static final Potion BaumedeFierabras = new Potion("Baume de Fierabras", "Brulure et cicacitre");
    public static final Potion BriseLame = new Potion("Brise-Lame", "Blessure magique");
    public static final Potion PotiondeDittany  = new Potion("Potion de Dittany ", "Blessure mineure");
}
