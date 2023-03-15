package com.isep.hpah.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Level {
    LEVEL1("Troll", 30, 7, "Boss1"),
    LEVEL2("Goblin", 45, 10, "Boss2"),
    LEVEL3("Dragon", 60, 13, "Boss3");

    private final String enemyName;
    private final int enemyHealth;
    private final int enemyAttack;
    private final String bossName;

    public static String getEnemyName(int level) {


        return null;
    }
}
