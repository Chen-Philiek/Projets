package com.isep.hpah.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractEnemyTest {

    private AbstractEnemy enemy;
    private Wizard wizard;

    @BeforeEach
    void setUp() {
        enemy = new Enemy("Enemy", 50, 100, EnemyType.TROLL); // Remplacez ConcreteEnemy par une classe concrète dérivée de AbstractEnemy
        wizard = new Wizard();
    }

    @Test
    void enemyturn() {
        enemy.enemyturn(wizard);
        // Vérifiez ici les résultats attendus après l'appel de enemyturn
        // par exemple, en vérifiant si les dégâts ont été infligés au bon personnage
        // en utilisant les méthodes appropriées de l'objet wizard
    }

    @Test
    void voldturn() {
        enemy.voldturn(wizard);
        // Vérifiez ici les résultats attendus après l'appel de voldturn
        // par exemple, en vérifiant si les dégâts ont été infligés au bon personnage
        // en utilisant les méthodes appropriées de l'objet wizard
    }

    @Test
    void takeDamage() {
        int initialHealth = enemy.getHealth();
        int damage = 20;

        enemy.takeDamage(wizard, damage);

        assertEquals(initialHealth - damage, enemy.getHealth());
        // Vérifiez ici d'autres résultats attendus après l'appel de takeDamage
    }

    @Test
    void getDamage() {
        int damage = 50;
        enemy.setDamage(damage);

        assertEquals(damage, enemy.getDamage());
    }

    @Test
    void getHealth() {
        int health = 100;
        enemy.setHealth(health);

        assertEquals(health, enemy.getHealth());
    }

    @Test
    void setDamage() {
        int damage = 70;
        enemy.setDamage(damage);

        assertEquals(damage, enemy.getDamage());
    }

    @Test
    void setHealth() {
        int health = 120;
        enemy.setHealth(health);

        assertEquals(health, enemy.getHealth());
    }
}
