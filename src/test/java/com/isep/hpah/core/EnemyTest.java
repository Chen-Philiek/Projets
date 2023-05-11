package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void createTroll() {
        Enemy troll = Enemy.createTroll();

        assertEquals("TROLL", troll.getName());
        assertEquals(10, troll.getDamage());
        assertEquals(30, troll.getHealth());
        assertEquals(EnemyType.TROLL, troll.getType());
    }

    @Test
    void creatPorkey() {
        Enemy porkey = Enemy.creatPorkey();

        assertEquals("Portkey", porkey.getName());
        assertEquals(0, porkey.getDamage());
        assertEquals(1, porkey.getHealth());
        assertEquals(EnemyType.PORTKEY, porkey.getType());
    }

    @Test
    void testToString() {
        Enemy enemy = new Enemy("Enemy", 5, 20, EnemyType.TROLL);
        String expectedString = "Enemy [type=Troll, name=Enemy, damage=5, health=20]";
        assertEquals(expectedString, enemy.toString());
    }
}
