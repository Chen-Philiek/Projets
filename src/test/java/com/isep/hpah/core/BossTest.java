package com.isep.hpah.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void createBasilik() {
        // Arrange
        Boss expectedBoss = new Boss("Basilic", 25, 55, BossLevel.BASILIC);

        // Act
        Boss actualBoss = Boss.createBasilik();

        // Assert
        assertEquals(expectedBoss.getName(), actualBoss.getName());
        assertEquals(expectedBoss.getDamage(), actualBoss.getDamage());
        assertEquals(expectedBoss.getHealth(), actualBoss.getHealth());
        assertEquals(expectedBoss.getTypeboss(), actualBoss.getTypeboss());
    }

    @Test
    void createVoledemort() {
        // Arrange
        Boss expectedBoss = new Boss("Voledemort", 35, 63, BossLevel.VOLEDEMORT);

        // Act
        Boss actualBoss = Boss.createVoledemort();

        // Assert
        assertEquals(expectedBoss.getName(), actualBoss.getName());
        assertEquals(expectedBoss.getDamage(), actualBoss.getDamage());
        assertEquals(expectedBoss.getHealth(), actualBoss.getHealth());
        assertEquals(expectedBoss.getTypeboss(), actualBoss.getTypeboss());
    }

    @Test
    void createDetraqueurs() {
        // Arrange
        Boss expectedBoss = new Boss("Détraqueurs", 25, 55, BossLevel.DETRAQUEURS);

        // Act
        Boss actualBoss = Boss.createDetraqueurs();

        // Assert
        assertEquals(expectedBoss.getName(), actualBoss.getName());
        assertEquals(expectedBoss.getDamage(), actualBoss.getDamage());
        assertEquals(expectedBoss.getHealth(), actualBoss.getHealth());
        assertEquals(expectedBoss.getTypeboss(), actualBoss.getTypeboss());
    }

    @Test
    void createDoubleBoss() {
        // Arrange
        Boss expectedBoss = new Boss("Voledemort et Peter", 60, 120, BossLevel.VOLEDEMORT_ET_PETER);

        // Act
        Boss actualBoss = Boss.createDoubleBoss();

        // Assert
        assertEquals(expectedBoss.getName(), actualBoss.getName());
        assertEquals(expectedBoss.getDamage(), actualBoss.getDamage());
        assertEquals(expectedBoss.getHealth(), actualBoss.getHealth());
        assertEquals(expectedBoss.getTypeboss(), actualBoss.getTypeboss());
    }

    @Test
    void createDolores() {
        // Arrange
        Boss expectedBoss = new Boss("Dolores Ombrage", 30, 60, BossLevel.DOLORES);

        // Act
        Boss actualBoss = Boss.createDolores();

        // Assert
        assertEquals(expectedBoss.getName(), actualBoss.getName());
        assertEquals(expectedBoss.getDamage(), actualBoss.getDamage());
        assertEquals(expectedBoss.getHealth(), actualBoss.getHealth());
        assertEquals(expectedBoss.getTypeboss(), actualBoss.getTypeboss());
    }

    @Test
    void createBella() {
        // Arrange
        Boss expectedBoss = new Boss("Bellatrix Lestrange", 32, 62, BossLevel.BELLATRIX);

        // Act
        Boss actualBoss = Boss.createBella();

        // Assert
        assertEquals(expectedBoss.getName(), actualBoss.getName());
        assertEquals(expectedBoss.getDamage(), actualBoss.getDamage());
        assertEquals(expectedBoss.getHealth(), actualBoss.getHealth());
        assertEquals(expectedBoss.getTypeboss(), actualBoss.getTypeboss());
    }

    @Test
    void createMangemorts() {
        // Arrange
        Boss expectedBoss = new Boss("Mangemorts", 15, 21, BossLevel.MANGEMORTS);

        // Act
        Boss actualBoss = Boss.createMangemorts();
// Assert
        assertEquals(expectedBoss.getName(), actualBoss.getName());
        assertEquals(expectedBoss.getDamage(), actualBoss.getDamage());
        assertEquals(expectedBoss.getHealth(), actualBoss.getHealth());
        assertEquals(expectedBoss.getTypeboss(), actualBoss.getTypeboss());
    }

    @Test
    void testToString() {
        // Arrange
        Boss boss = new Boss("Basilic", 25, 55, BossLevel.BASILIC);
        String expectedString = "Boss [type=BASILIC, name=Basilic, damage=25, health=55]";

        // Act
        String actualString = boss.toString();

        // Assert
        assertEquals(expectedString, actualString);
    }
}

