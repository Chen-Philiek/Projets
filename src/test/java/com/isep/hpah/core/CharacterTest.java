package com.isep.hpah.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private Character character;

    @BeforeEach
    void setUp() {
        character = new CharacterImpl();
    }

    @Test
    void testGetDogdeChance() {
        int dodgeChance = character.getDogdeChance();
        assertEquals(0, dodgeChance);
    }

    @Test
    void testGetName() {
        String name = character.getName();
        assertNull(name);
    }

    @Test
    void testGetDamage() {
        int damage = character.getDamage();
        assertEquals(0, damage);
    }

    @Test
    void testGetHealth() {
        int health = character.getHealth();
        assertEquals(0, health);
    }

    @Test
    void testIsAlive() {
        boolean alive = character.isAlive();
        assertFalse(alive);
    }

    @Test
    void testSetDogdeChance() {
        character.setDogdeChance(50);
        int dodgeChance = character.getDogdeChance();
        assertEquals(50, dodgeChance);
    }

    @Test
    void testSetName() {
        character.setName("John Doe");
        String name = character.getName();
        assertEquals("John Doe", name);
    }

    @Test
    void testSetDamage() {
        character.setDamage(10);
        int damage = character.getDamage();
        assertEquals(10, damage);
    }

    @Test
    void testSetHealth() {
        character.setHealth(100);
        int health = character.getHealth();
        assertEquals(100, health);
    }

    @Test
    void testSetAlive() {
        character.setAlive(true);
        boolean alive = character.isAlive();
        assertTrue(alive);
    }

    // Implémentation de la classe Character pour les besoins des tests
    private static class CharacterImpl extends Character {
        // Implémentation vide pour les méthodes abstraites non testées
    }
}
