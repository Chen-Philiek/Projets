package com.isep.hpah.core;

import java.util.List;
import java.util.Scanner;
import lombok.*;
@AllArgsConstructor
public class Combat {
    @Getter @Setter private Wizard wizard;
    @Getter @Setter private AbstractEnemy enemy;
    @Getter @Setter private AbstractEnemy boss;
    @Getter @Setter private boolean isBossFight;

    public Combat(Wizard wizard, AbstractEnemy enemy, AbstractEnemy boss) {
        this.wizard = wizard;
        this.enemy = enemy;
        this.boss = boss;
        this.isBossFight = false;
    }

    public void start() {

        System.out.println("You are now facing a " + enemy.getName() + " with " + enemy.getHealth() + " health and " + enemy.getDamage() + " damage.");
        System.out.println("Choose your action: 1. Cast spell 2. Use potion 3. Flee");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                castSpell();
                break;
            case 2:
                usePotion();
                break;
            case 3:
                flee();
                break;
            default:
                System.out.println("Invalid action");
        }
    }
//Potion incomplet
    public void usePotion() {
        List<Potion> potions = wizard.getPotions();
        if (potions.isEmpty()) {
            System.out.println("You don't have any potion!");
            return;
        }

        System.out.println("Choose the potion to use:");
    }
    public boolean flee() {
        int fleeChance = (int) (Math.random() * 101); // Tirage aléatoire d'un nombre entre 0 et 100
        if (fleeChance > 50) {
            System.out.println(wizard.getName() + " réussit à fuir !");
            return true;
        } else {
            System.out.println(wizard.getName() + " ne parvient pas à fuir et doit combattre " + enemy.getName() + " !");
            return false;
        }
    }



    public void castSpell() {
        List<Spell> knownSpells = wizard.getKnownSpells();
        if (knownSpells.isEmpty()) {
            System.out.println("You don't know any spell!");
            return;
        }

        System.out.println("Choose the spell to cast:");
        for (int i = 0; i < knownSpells.size(); i++) {
            System.out.println((i + 1) + ". " + knownSpells.get(i).getName() + " (" + knownSpells.get(i).getDamage() + " damage)");
        }

        Scanner scanner = new Scanner(System.in);
        int spellIndex = scanner.nextInt() - 1;
        if (spellIndex < 0 || spellIndex >= knownSpells.size()) {
            System.out.println("Invalid spell selection!");
            return;
        }

        Spell spell = knownSpells.get(spellIndex);
        int damage = spell.getDamage();
        System.out.println("You cast " + spell.getName() + " and deal " + damage + " damage to " + enemy.getName());
        enemy.takeDamage(damage);

        if (enemy.getHealth() <= 0) {
            System.out.println("You defeated the " + enemy.getName() + "!");
            if (boss != null && !isBossFight) {
                System.out.println("But beware! The boss is coming!");
                isBossFight = true;
                enemy = boss;
                boss = null;
            } else {
                System.out.println("You won the combat!");
                return;
            }
        }


    }


}