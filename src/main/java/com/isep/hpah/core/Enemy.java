package com.isep.hpah.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Enemy extends AbstractEnemy{
    private String name;
    private int health;
    private int attack;

    public void attack(Wizard wizard) {

    }
}

@Getter @AllArgsConstructor
class Boss {
    private String name;
    private int health;
    private int attack;
}

