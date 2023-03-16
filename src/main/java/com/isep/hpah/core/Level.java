package com.isep.hpah.core;

import lombok.*;

public class Level {
    @Getter @Setter
    private String chapter;

    public Level() {
        this.chapter = "Chapter 1";
    }
}