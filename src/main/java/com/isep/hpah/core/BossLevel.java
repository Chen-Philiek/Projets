package com.isep.hpah.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BossLevel {
    BOSS1("Boss1", 100, 15),
    BOSS2("Boss2", 150, 20),
    BOSS3("Boss3", 200, 25);

    private final String bossName;
    private final int bossHealth;
    private final int bossAttack;
}
