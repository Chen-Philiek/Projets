package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CoreTest {

    @Test
    void randomCore() {
        // Créer un ensemble avec toutes les valeurs possibles de l'énumération Core
        Set<Core> allCores = new HashSet<>(Arrays.asList(Core.values()));

        // Effectuer plusieurs appels à randomCore et vérifier si le résultat est dans l'ensemble des valeurs possibles
        for (int i = 0; i < 100; i++) {
            Core randomCore = Core.randomCore();
            assertTrue(allCores.contains(randomCore));
        }
    }

    @Test
    void values() {
        // Vérifier si les valeurs renvoyées par la méthode values correspondent à toutes les valeurs de l'énumération Core
        Core[] expectedValues = {Core.PHOENIX_FEATHER, Core.DRAGON_HEARTSTRING, Core.UNICORN_HAIR, Core.VEELA_HAIR};
        assertArrayEquals(expectedValues, Core.values());
    }

    @Test
    void valueOf() {
        // Vérifier si la méthode valueOf renvoie la bonne valeur pour chaque nom d'énumération Core
        assertEquals(Core.PHOENIX_FEATHER, Core.valueOf("PHOENIX_FEATHER"));
        assertEquals(Core.DRAGON_HEARTSTRING, Core.valueOf("DRAGON_HEARTSTRING"));
        assertEquals(Core.UNICORN_HAIR, Core.valueOf("UNICORN_HAIR"));
        assertEquals(Core.VEELA_HAIR, Core.valueOf("VEELA_HAIR"));
    }
}
