package com.isep.hpah.core;

import java.util.List;
import java.util.Scanner;

import lombok.*;
@AllArgsConstructor
public class Combat {

    @Getter @Setter private static AbstractEnemy enemy;
    @Getter @Setter private AbstractEnemy boss;
    //@Getter @Setter private AbstractSpell knowSpells;
    @Getter @Setter private boolean isBossFight;

    public Combat(AbstractEnemy enemy, AbstractEnemy boss) {
        this.enemy = enemy;
        this.boss = boss;
        this.isBossFight = false;
    }

    public void ennemyappear(){
        System.out.println("You are now facing a " + enemy.getName() + " with " + enemy.getHealth() + " health and " + enemy.getDamage() + " damage.");

    }
    public void start(Wizard wizard) {

        System.out.println("Choose your action:\n1. Cast spell\n2. Use potion\n3. Flee");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                castSpell(wizard);
                break;
            case 2:
                usePotion(wizard);
                break;
            case 3:
                flee(wizard);
                break;
            default:
                System.out.println("Invalid action");
        }
    }
//Potion incomplet
    public void usePotion(Wizard wizard) {
        List<Potion> potions = wizard.getPotions();
        if (potions.isEmpty()) {
            System.out.println("You don't have any potion!");
            return;
        }
        System.out.println("Choose the potion to use:");
        for (int i = 0; i < potions.size(); i++) {
            System.out.println((i + 1) + ". " + potions.get(i).getName() + " (" + potions.get(i).getHealAmount() + " heal)");
        }
        Scanner scanner = new Scanner(System.in);
        int potionIndex = scanner.nextInt()-1;
        Potion potion = potions.get(potionIndex);
        int heal1 = (int) potion.getHealAmount();
        System.out.println("Vous utilisez " + potion.getName() + " et vous régénérez " + heal1 + " de points de vie\n");
        wizard.Healing(wizard, heal1);

    }
    public boolean flee(Wizard wizard) {
        int fleeChance = (int) (Math.random() * 101); // Tirage aléatoire d'un nombre entre 0 et 100
        if (fleeChance > 50) {
            System.out.println(wizard.getName() + " réussit à fuir !");
            return true;
        } else {
            System.out.println(wizard.getName() + " ne parvient pas à fuir et doit combattre " + enemy.getName() + " !");
            return false;
        }

    }

// WIZARD ET ENEMY TURN
    public static void enemyturn(Wizard wizard){
        if (enemy.getHealth() >= 0){
            int damage1 = enemy.getDamage();
            System.out.println("C'est au tour du " + enemy.getName() + "!");
            System.out.println("Le " + enemy.getName() + " vous attaque et vous inflige : " + damage1 + " de dégâts");
            wizard.takeDamage(wizard,damage1);
        }

    }
    public void wizardturn(Wizard wizard){
        List<Spell>knownSpells = wizard.getKnownSpells();
        Scanner scanner = new Scanner(System.in);
        int spellIndex = scanner.nextInt()-1;
        Spell spell = knownSpells.get(spellIndex);
        int damage = spell.getDamage();
        System.out.println("Vous lancez " + spell.getName() + " en faisant tomber un rocher sur la tête et infligez  " + damage + " de dégâts au " + enemy.getName() + "\n");
        enemy.takeDamage(damage);



    }

    public void castSpell(Wizard wizard) {
        List<Spell> knownSpells = wizard.getKnownSpells();
        if (knownSpells.isEmpty()) {
            System.out.println("You don't know any spell!");
            return;
        }
        System.out.println("Choose the spell to cast:");
        for (int i = 0; i < knownSpells.size(); i++) {
            System.out.println((i + 1) + ". " + knownSpells.get(i).getName() + " (" + knownSpells.get(i).getDamage() + " damage)");

        }


        wizardturn(wizard);
        enemyturn(wizard);



           /* if (boss != null && !isBossFight) {
                System.out.println("But beware! The boss is coming!");
                isBossFight = true;
                enemy = boss;
                boss = null;
            } else {
                System.out.println("You won the combat!");
                return;
            }

            */





    }
    public void fight(Wizard wizard){

        while (enemy.getHealth() > 0) {
            start(wizard);
        }
        if (enemy.getHealth() <= 0 ) {
            System.out.println("L'ennemie " + enemy.getName() + " a été vaincu");
        }

    }



}