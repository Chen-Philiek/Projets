package com.isep.hpah.core;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Random;
import java.util.Scanner;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Wand {
    private Core core;
    private int size;

    public static void Tot(){
        Wand.randomWand();
        Wait.wait(2000);

    }

    private static final Random ran = new Random();

    public static Wand randomWand() {
        Wand wand = new Wand();
        wand.setCore(Core.randomCore());
        return wand;
    }



    public static int randomWandSize() {

        System.out.println("Votre baguette magique à une taille de : " + randomSize());



    }

    private static int randomSize() {

    }


}


