package com.isep.hpah.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitTest {

    @Test
    void testWait() {
        long startTime = System.currentTimeMillis();

        // Appel de la méthode wait() avec une attente de 1000 ms
        Wait.wait(1000);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        // Vérification que le temps d'attente est proche de 1000 ms (avec une marge de 100 ms)
        assertTrue(elapsedTime >= 900 && elapsedTime <= 1100);
    }
}
