package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpellTest {

    @Test
    void listSpells() {
        // Exécution de la méthode listSpells()
        Spell.listSpells(new Wizard());

        // Vérification que la liste de sorts connus du sorcier contient le sort choisi
        assertTrue(new Wizard().getKnownSpells().contains(Spell.WingardiumLeviosa));
    }

    @Test
    void spellStat() {
        // Création d'un sort de test
        Spell spell = new Spell("WingardiumLeviosa", "Throw rock on the head of the enemy", 20);

        // Modification des statistiques du sort
        spell.spellStat(5);

        // Vérification que les dégâts du sort ont été modifiés
        assertEquals(25, spell.getDamage());
    }

    @Test
    void getDamage() {
        // Création de sorts de test
        Spell spell1 = new Spell("WingardiumLeviosa", "Throw rock on the head of the enemy", 20);
        Spell spell2 = new Spell("Incendio", "Creates fire", 9);

        // Vérification des dégâts des sorts
        assertEquals(20, spell1.getDamage());
        assertEquals(9, spell2.getDamage());
    }

    @Test
    void getName() {
        // Création d'un sort de test
        Spell spell = new Spell("WingardiumLeviosa", "Throw rock on the head of the enemy", 20);

        // Vérification du nom du sort
        assertEquals("WingardiumLeviosa", spell.getName());
    }

    @Test
    void getDescription() {
        // Création d'un sort de test
        Spell spell = new Spell("WingardiumLeviosa", "Throw rock on the head of the enemy", 20);

        // Vérification de la description du sort
        assertEquals("Throw rock on the head of the enemy", spell.getDescription());
    }

    @Test
    void setName() {
        // Création d'un sort de test
        Spell spell = new Spell();

        // Définition du nom du sort
        spell.setName("WingardiumLeviosa");

        // Vérification du nom du sort
        assertEquals("WingardiumLeviosa", spell.getName());
    }

    @Test
    void setDescription() {
        // Création d'un sort de test
        Spell spell = new Spell();

        // Définition de la description du sort
        spell.setDescription("Throw rock on the head of the enemy");

        // Vérification de la description du sort
        assertEquals("Throw rock on the head of the enemy", spell.getDescription());
    }

    @Test
    void setDamage() {
        // Création d'un sort de test
        Spell spell = new Spell();

        // Définition des dégâts du sort
        spell.setDamage(20);

        // Vérification des dégâts du sort
        assertEquals(20, spell.getDamage());
    }
}
