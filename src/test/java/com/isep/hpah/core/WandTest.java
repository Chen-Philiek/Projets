package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WandTest {

    @Test
    void tot() {
        // Exécution de la méthode Tot()
        Wand.Tot();

        // Vérification que la méthode s'exécute sans erreur
        assertTrue(true);
    }

    @Test
    void randomWand() {
        // Exécution de la méthode randomWand()
        Wand wand = Wand.randomWand();

        // Vérification que le noyau de la baguette n'est pas nul
        assertNotNull(wand.getCore());
    }

    @Test
    void randomWandSize() {
        // On vérifie simplement que la méthode ne provoque pas d'exception ou d'erreur
        assertDoesNotThrow(Wand::randomWandSize);
    }

    @Test
    void getWand() {
        // Exécution de la méthode getWand()
        Wand wand = Wand.getWand();

        // Vérification que le noyau de la baguette n'est pas nul
        assertNotNull(wand.getCore());
    }

    @Test
    void getCore() {
        // Création d'une baguette de test
        Core core = Core.PHOENIX_FEATHER;

        // Création d'une baguette avec le noyau de test
        Wand wand = new Wand(core, 12);

        // Vérification du noyau de la baguette
        assertEquals(core, wand.getCore());
    }

    @Test
    void getSize() {
        // Création d'une baguette de test
        Wand wand = new Wand(Core.UNICORN_HAIR, 15);

        // Vérification de la taille de la baguette
        assertEquals(15, wand.getSize());
    }

    @Test
    void setCore() {
        // Création d'une baguette de test
        Wand wand = new Wand();

        // Création d'un nouveau noyau de test
        Core core = Core.DRAGON_HEARTSTRING;

        // Définition du noyau de la baguette
        wand.setCore(core);

        // Vérification du noyau de la baguette
        assertEquals(core, wand.getCore());
    }

    @Test
    void setSize() {
        // Création d'une baguette de test
        Wand wand = new Wand();

        // Définition de la taille de la baguette
        wand.setSize(18);

        // Vérification de la taille de la baguette
        assertEquals(18, wand.getSize());
    }
}
