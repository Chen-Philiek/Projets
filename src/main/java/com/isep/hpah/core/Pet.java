package com.isep.hpah.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pet {

    private List<String> names;

    public Pet() {
        this.names = new ArrayList<>();
        this.names.add("Owl");
        this.names.add("Cat");
        this.names.add("Rat");
        this.names.add("Bat");
        this.names.add("Dog");
        this.names.add("Fox");
        this.names.add("Cow");
        this.names.add("Pig");
        this.names.add("Hen");
        this.names.add("Emu");
    }

    public String getRandomName() {
        Random random = new Random();
        int index = random.nextInt(names.size());
        return names.get(index);
    }
}
