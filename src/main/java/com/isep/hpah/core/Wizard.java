package com.isep.hpah.core;

import lombok.*;
import java.util.List;
import java.util.ArrayList;

public class Wizard extends Character{
    @Getter @Setter private Pet pet;
    @Getter @Setter private Wand wand;
    @Getter @Setter  private House house;
    @Getter @Setter private List<Potion> potions;
    @Getter @Setter private List<Spell> knownSpells;



}





