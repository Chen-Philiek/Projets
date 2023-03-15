package com.isep.hpah.core;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Combat {
    private Wizard wizard;
    private Enemy enemy;
    private int level;
    private int enemyCount;
    private int bossCount;
    private boolean bossFight;

    public Combat(Wizard wizard, Enemy enemy, int level) {
        this.wizard = wizard;
        this.enemy = enemy;
        this.level = level;
        this.enemyCount = 0;
        this.bossCount = 0;
        this.bossFight = false;
    }




    public void start() {
        System.out.println("Un ennemi apparait !");
        while (wizard.isAlive() && enemy.isAlive()) {
            wizard.attack(enemy);
            if (!enemy.isAlive()) {
                enemyCount++;
                if (enemyCount % 3 == 0) {
                    bossFight = true;
                    bossCount++;
                    System.out.println("Vous venez de vaincre l'ennemi n°" + enemyCount + ", préparez-vous pour le boss !");
                } else {
                    System.out.println("Vous venez de vaincre l'ennemi n°" + enemyCount + ", un nouvel ennemi apparait !");
                    enemy = generateEnemy();
                }
                wizard.heal(0.2);
                wizard.increaseAttack(0.1);
                learnNewSpell();
            } else {
                enemy.attack(wizard);
            }
        }
        if (wizard.isAlive()) {
            System.out.println("Vous avez vaincu l'ennemi !");
        } else {
            System.out.println("Vous avez été vaincu...");
        }
    }

    private Enemy generateEnemy() {
        int enemyHealth = 30 + level * 15;
        int enemyAttack = 7 + level * 3;
        String enemyName = Level.getEnemyName(level);
        return new Enemy(enemyName, enemyHealth, enemyAttack);
    }

    private void learnNewSpell() {
        if (wizard.getKnownSpells().size() < SpellList.values().length) {
            System.out.println("Voulez-vous apprendre un nouveau sort ?");
            System.out.println("0 : Non");
            int i = 1;
            for (SpellList spell : SpellList.values()) {
                if (!wizard.getKnownSpells().contains(spell)) {
                    System.out.println(i + " : " + spell.name());
                    i++;
                }
            }
         /*   Object IOUtils = null;
            int choice = IOUtils.readIntInput("Choix : ");
            if (choice > 0 && choice < i) {
                SpellList spell = SpellList.values()[choice-1];
                wizard.getKnownSpells().add(spell);
                System.out.println("Vous avez appris le sort " + spell.name() + " !");

          */
            }
        }
    }

