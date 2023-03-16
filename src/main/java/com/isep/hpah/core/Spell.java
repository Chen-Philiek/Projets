package com.isep.hpah.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Spell {
    private String name;
    private String description;

    public static Spell listSpells() {
        Spell spell = new Spell();
        spell.setSpellName(chooseSpell());
        return spell;
    }

    private void setSpellName(SpellList chooseSpell) {
        this.name = chooseSpell.getName();
        this.description = chooseSpell.getDescription();
    }

    private static SpellList chooseSpell() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a spell :");
        int count = 1;
        for (SpellList s : SpellList.values()) {
            System.out.print(count + ")");
            System.out.println(s.getName());
            count += 1;
        }
        int numberSpell = scanner.nextInt();
        SpellList chosenSpell = null;
        switch (numberSpell) {
            case 1:
                chosenSpell = SpellList.Expelliarmus;
                break;
            case 2:
                chosenSpell = SpellList.Sectumsempra;
                break;
            case 3:
                chosenSpell = SpellList.Incendio;
                break;

        }
        System.out.println("You chose the spell " + chosenSpell.getName());
        return chosenSpell;
    }


    public int getDamage() {
        int damage = 0;
        switch (this.name) {
            case "Expelliarmus":
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

}

enum SpellList {
    Expelliarmus("Expelliarmus", "Disarms opponent"),
    Sectumsempra("Sectumsempra", "Causes severe wounds"),
    Incendio("Incendio", "Creates fire");


    @Getter
    private final String name;
    @Getter
    private final String description;

    SpellList(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
