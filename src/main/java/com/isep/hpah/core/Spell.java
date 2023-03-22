package com.isep.hpah.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spell {
    private String name;
    private String description;
    public static List<String> knownSpells = new ArrayList<>();

    public static Spell listSpells(Wizard wizard) {
        Spell spell = new Spell();
        spell.setName(chooseSpell(wizard));
        return spell;
    }

    private static String chooseSpell(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a spell : \n 1.WingardiumLeviosa \n 2.Sectumsempra \n 3.Incendio");


        int numberSpell = scanner.nextInt();
        Spell chosenSpell = null;
        switch (numberSpell) {
            case 1:
                chosenSpell = Spell.WingardiumLeviosa;
                break;
            case 2:
                chosenSpell = Spell.Sectumsempra;
                break;
            case 3:
                chosenSpell = Spell.Incendio;
                break;
            default:
                chooseSpell(wizard);

        }
        System.out.println("You chose the spell " + chosenSpell.getName());

        wizard.getKnownSpells().add(chosenSpell);
        return chosenSpell.getName();
    }

    public int getDamage() {
        int damage = 0;
        switch (this.name) {
            case "WingardiumLeviosa":
                damage = 10;
                break;
            case "Sectumsempra":
                damage = 20;
                break;
            case "Incendio":
                damage = 15;
                break;
        }
        return damage;
    }

    public static final Spell WingardiumLeviosa = new Spell("WingardiumLeviosa", "Throw rock on the head of the enemy");
    public static final Spell Sectumsempra = new Spell("Sectumsempra", "Causes severe wounds");
    public static final Spell Incendio = new Spell("Incendio", "Creates fire");

}
