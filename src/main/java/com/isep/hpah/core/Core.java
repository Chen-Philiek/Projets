package com.isep.hpah.core;

import java.util.Random;

public enum Core {
    PHOENIX_FEATHER,
    DRAGON_HEARTSTRING,
    UNICORN_HAIR,
    VEELA_HAIR;
    private static final Random ran = new Random();

    public static Core randomCore(){
        Core[] cores = values();
        Core coreName = cores[ran.nextInt(cores.length)];
        System.out.println("Vous avez une baguette magique avec ce coeur la  : " + coreName);
        return coreName;
    }


}


