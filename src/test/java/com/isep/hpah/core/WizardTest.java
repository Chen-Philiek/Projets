package com.isep.hpah.core;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    private Wizard wizard;


    @Test
    void testRandomHealth() {
        int health = Wizard.randomHealth();
        assertTrue(health >= 0, "Health should be non-negative");
    }

    @Test
    void testMaxHealth() {
        int maxHealth = Wizard.MaxHealth();
        assertTrue(maxHealth > 0, "Max health should be positive");
    }

    @Test
    void testStart() {
        // TODO: Write test case for start() method
    }

    @Test
    void testPassChapter() {
        assertFalse(wizard.passChapter(0), "Passing chapter should return false if health is zero");

        // TODO: Write more test cases for passChapter() method
    }

    @Test
    void testWizardTurn() {
        // TODO: Write test case for wizardturn() method
    }

    @Test
    void testUsePotion() {
        // Create a wizard with some potions
        List<Potion> potions = new ArrayList<>();
        potions.add(Potion.PotiondeDittany);
        wizard.setPotions(potions);

        // Use a potion
        wizard.usePotion();

        // Check if the potion is used and health is increased
        assertEquals(0, wizard.getPotions().size(), "Potion should be used and removed from the list");
        assertTrue(wizard.getHealth() > 0, "Health should be increased after using a potion");

        // TODO: Write more test cases for usePotion() method
    }

    @Test
    void testFlee() {
        // TODO: Write test case for flee() method
    }

    @Test
    void testDrop() {
        // TODO: Write test case for drop() method
    }

    @Test
    void testCastSpell() {
        // Create a wizard with some known spells
        List<Spell> knownSpells = new ArrayList<>();
        knownSpells.add(Spell.Accio);
        wizard.setKnownSpells(knownSpells);

        // Cast a spell



    }

    @Test
    void testFight() {

    }

    @Test
    void testTakeDamage() {

    }

    @Test
    void testHealing() {

    }

    @Test
    void testChapterOne() {

    }

    @Test
    void testChapterTwo() {

    }

    @Test
    void testChapterThree() {

    }

    // Add more test cases for other methods

}
