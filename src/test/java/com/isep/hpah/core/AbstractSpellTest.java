package com.isep.hpah.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractSpellTest {

    @Test
    void getName_shouldReturnSpellName() {
        // Arrange
        String expectedName = "Expelliarmus";
        AbstractSpell spell = new ConcreteSpell(expectedName, "Description");

        // Act
        String actualName = spell.getName();

        // Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    void getDescription_shouldReturnSpellDescription() {
        // Arrange
        String expectedDescription = "A spell to disarm the opponent.";
        AbstractSpell spell = new ConcreteSpell("Expelliarmus", expectedDescription);

        // Act
        String actualDescription = spell.getDescription();

        // Assert
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void setName_shouldSetSpellName() {
        // Arrange
        String expectedName = "Expecto Patronum";
        AbstractSpell spell = new ConcreteSpell("Expelliarmus", "Description");

        // Act
        spell.setName(expectedName);

        // Assert
        assertEquals(expectedName, spell.getName());
    }

    @Test
    void setDescription_shouldSetSpellDescription() {
        // Arrange
        String expectedDescription = "A spell to conjure a Patronus.";
        AbstractSpell spell = new ConcreteSpell("Expelliarmus", "Description");

        // Act
        spell.setDescription(expectedDescription);

        // Assert
        assertEquals(expectedDescription, spell.getDescription());
    }

    // Concrete Spell class for testing purposes
    private static class ConcreteSpell extends AbstractSpell {
        public ConcreteSpell(String name, String description) {
            super(name, description);
        }
    }
}
