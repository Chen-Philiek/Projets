package com.isep.hpah.core;

public class Wand {

    private Core core;
    private int size;

    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }
    public String getDescription() {
        return core.getName() + " de taille " + size + " cm";
    }

    public int getPower() {
        // calculer la puissance de la baguette en fonction du noyau et de la taille
        return core.getPower() * size;
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
