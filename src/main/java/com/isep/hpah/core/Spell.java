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
public class Spell extends AbstractSpell{
    private String name;
    private String description;
    private int damage;
    public static List<String> knownSpells = new ArrayList<>();



    public static void listSpells(Wizard wizard) {
        Spell spell = new Spell();
        spell.setName(chooseSpell(wizard));
    }

    private static String chooseSpell(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a spell \uD83E\uDD14: \n 1.WingardiumLeviosa (recommandé en début d'aventure)\n 2.Incendio");


        int numberSpell = scanner.nextInt();
        Spell chosenSpell = null;
        switch (numberSpell) {
            case 1 -> chosenSpell = Spell.WingardiumLeviosa;
            case 2 -> chosenSpell = Spell.Incendio;
            default -> chooseSpell(wizard);
        }
        assert chosenSpell != null;
        System.out.println("You chose the spell " + chosenSpell.getName());

        wizard.getKnownSpells().add(chosenSpell);
        return chosenSpell.getName();
    }

    public void spellStat(int extraDamage) {
        setDamage(getDamage() + extraDamage);
    }
    public int getDamage() {

        return switch (this.name) {
            case "WingardiumLeviosa" -> 20;
            case "Sectumsempra" -> 21;
            case "Incendio" -> 9;
            case "Accio" -> 22;
            case "GryffindorSword" -> 24;
            case "ExpectoPatronum" -> 23;
            default -> 0;
        };
    }
    public static final Spell WingardiumLeviosa = new Spell("WingardiumLeviosa", "Throw rock on the head of the enemy",20);
    public static final Spell Sectumsempra = new Spell("Sectumsempra", "Causes severe wounds",0);
    public static final Spell Incendio = new Spell("Incendio", "Creates fire",9);
    public static final Spell Accio = new Spell("Accio", "use enemy crocs",22);
    public static final Spell GryffindorSword = new Spell("GryffindorSword", "Legendary sword",24);
    public static final Spell ExpectoPatronum = new Spell("ExpectoPatronum", "Fait fuir l'ennemie",23);


}
