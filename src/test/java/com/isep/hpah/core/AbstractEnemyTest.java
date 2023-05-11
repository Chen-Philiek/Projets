package com.isep.hpah.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractEnemyTest {

    @Test
    void enemyturn_shouldDamageWizard() {
        // Arrange
        Enemy enemy = new Enemy("Enemy", 10, 100, EnemyType.TROLL);
        Wizard wizard = new Wizard();
        int initialHealth = wizard.getHealth();

        // Act
        enemy.enemyturn(wizard);

        // Assert
        assertEquals(initialHealth - enemy.getDamage(), wizard.getHealth());
    }

    @Test
    void enemyturn_shouldNotDamageWizardWhenHealthZero() {
        // Arrange
        Enemy enemy = new Enemy("Enemy", 10, 0, EnemyType.TROLL);
        Wizard wizard = new Wizard();
        int initialHealth = wizard.getHealth();

        // Act
        enemy.enemyturn(wizard);

        // Assert
        assertEquals(initialHealth, wizard.getHealth());
    }

    @Test
    void voldturn_shouldDamageWizard() {
        // Arrange
        Enemy enemy = new Enemy("Enemy", 20, 100, EnemyType.TROLL);
        Wizard wizard = new Wizard();
        int initialHealth = wizard.getHealth();

        // Act
        enemy.voldturn(wizard);

        // Assert
        assertEquals(initialHealth - enemy.getDamage(), wizard.getHealth());
    }

    @Test
    void voldturn_shouldNotDamageWizardWhenHealthZero() {
        // Arrange
        Enemy enemy = new Enemy("Enemy", 20, 0, EnemyType.TROLL);
        Wizard wizard = new Wizard();
        int initialHealth = wizard.getHealth();

        // Act
        enemy.voldturn(wizard);

        // Assert
        assertEquals(initialHealth, wizard.getHealth());
    }

    @Test
    void takeDamage_shouldReduceEnemyHealth() {

    }

    @Test
    void takeDamage_shouldReduceEnemyHealthWithAdditionalDamageForSlytherinWizard() {
        // Arrange
        Enemy enemy = new Enemy("Enemy", 10, 100, EnemyType.TROLL);
        int damage = 20;
        int expectedHealth = enemy.getHealth() - (damage + 10);
        Wizard wizard = new Wizard();

        // Act
        enemy.takeDamage(wizard, damage);

        // Assert
        assertEquals(expectedHealth, enemy.getHealth());
    }

    @Test
    void takeDamage_shouldSetEnemyAliveToFalseWhenHealthZero() {

    }

    @Test
    void takeDamage_shouldNotSetEnemyAliveToFalseWhenHealthGreaterThanZero() {
        // Arrange
        Enemy enemy = new Enemy("Enemy", 10, 20, EnemyType.TROLL);

    }

}
