package com.isep.hpah.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;




@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Potion {
    private String name;
    private String description;

    public static Potion ListPotion() {
        Potion potion = new Potion();
        potion.setPotion(ChoosePotion());
        return potion;
    }

    private void setPotion(PotionList choosePotion) {
    }

    private static PotionList ChoosePotion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the potion you want as first potion : ");
        int count = 1;
        for (PotionList p : PotionList.values()) {
            System.out.print(count + ")");
            System.out.println(p);
            count += 1;
        }
        int numberPotion = scanner.nextInt();
        PotionList ChoosedPotion ;
        switch (numberPotion) {
            case 1:
                ChoosedPotion = PotionList.Powerup;
                break;
            case 2:
                ChoosedPotion = PotionList.Speedup;
                break;
            case 3:
                ChoosedPotion = PotionList.Defenseup;
                break;
            default:
                throw new IllegalArgumentException("ee");


        }
        System.out.println("Vous venez d'obtenir la potion " + ChoosedPotion);
        return ChoosedPotion;

    }
}
