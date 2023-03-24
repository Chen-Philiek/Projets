package com.isep.hpah.core;

import lombok.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wizard extends Character{
    @Getter @Setter private Pet pet;
    @Getter @Setter private Wand wand;
    @Getter @Setter  private House house;
    @Getter @Setter private List<Potion> potions;
    @Getter @Setter private List<Spell> knownSpells;
    @Getter @Setter private int health;
    @Getter @Setter private int max_health;
    private static final Random ran = new Random();

    public static int randomHealth(){
        System.out.println("Vous avez : " + health() + " points de vies");
        return health();
    }
    private static int health() {
        int health = 500 ;
        return health;
    }

    private static int max_health(){
        int max_health = 500;
        return max_health;
    }

    public static int MaxHealth(){
        System.out.println("Vous avez un au maximum " + max_health() + " au début de la partie");
        return max_health();
    }

    public void start(AbstractEnemy ennemies) {

        System.out.println("Choose your action:\n1. Cast spell\n2. Use potion\n3. Flee");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                this.castSpell(ennemies);
                break;
            case 2:
                this.usePotion();
                break;
            case 3:
                this.flee(ennemies);
                break;
            default:
                System.out.println("Invalid action");
        }
    }
    public boolean passChapter(){
        for (int i =1; i<8; i++){
        if (i == 1 && this.getHealth()>0){
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterTwo();
            i+=1;
        }if (i ==2 && this.getHealth()>0){
            System.out.println("Vous êtes autorisés à aller dans le chapitre suivant !");
            ChapterThree();
        }
        else{
            return false;}
        }
        return true;
    }
    public boolean wizardturn(AbstractEnemy ennemies){
        if (ennemies.getHealth() > 0 && this.getHealth()>0) {
            this.start(ennemies);
        }else{
            drop(ennemies);
            return false ;
        }
        return true;
    }
    //Potion part
    public void usePotion() {
        List<Potion> potions = this.getPotions();
        if (potions.isEmpty()) {
            System.out.println("You don't have any potion!");
            return;
        }
        System.out.println("Choose the potion to use:");
        for (int i = 0; i < potions.size(); i++) {
            System.out.println((i + 1) + ". " + potions.get(i).getName() + " (" + potions.get(i).getHealAmount() + " heal)");
        }
        Scanner scanner = new Scanner(System.in);
        int potionIndex = scanner.nextInt()-1;
        Potion potion = potions.get(potionIndex);
        int heal1 = (int) potion.getHealAmount();
        System.out.println("Vous utilisez " + potion.getName() + " et vous régénérez " + heal1 + " de points de vie\n");
        this.Healing( heal1);

    }
    // Flee part
    public boolean flee(AbstractEnemy ennemies) {
        int fleeChance = (int) (Math.random() * 101); // Tirage aléatoire d'un nombre entre 0 et 100
        if (fleeChance > 50) {
            System.out.println(this.getName() + " réussit à fuir !");
            return true;
        } else {
            System.out.println(this.getName() + " ne parvient pas à fuir et doit combattre " + ennemies.getName() + " !");
            return false;
        }
    }
    // Drop Potion part
    public boolean drop(AbstractEnemy ennemies) {
        int dropPotion = (int) (Math.random() * 101); // Tirage aléatoire d'un nombre entre 0 et 100
        if (dropPotion > 50) {
            this.getPotions().add(Potion.G);
            System.out.println("Vous avez obtenue une nouvelle potion !" );
            return true;
        }if (dropPotion >70){
            this.getPotions().add(Potion.M);
            System.out.println("Vous avez obtenue une nouvelle potion !" );
            return true;
        }if (dropPotion > 90){
            this.getPotions().add(Potion.L);
            System.out.println("Vous avez obtenue une nouvelle potion !" );
            return true;
        }
        else {
            System.out.println("L'ennemie n'a rien laissé sur lui ");
            return false;
        }

    }

    public void castSpell(AbstractEnemy ennemies) {
        List<Spell> knownSpells = this.getKnownSpells();
        if (knownSpells.isEmpty()) {
            System.out.println("You don't know any spell!");
            return;
        }
        System.out.println("Choose the spell to cast:");
        for (int i = 0; i < knownSpells.size(); i++) {
            System.out.println((i + 1) + ". " + knownSpells.get(i).getName() + " (" + knownSpells.get(i).getDamage() + " damage)");

        }
        Scanner scanner = new Scanner(System.in);
        int spellIndex = scanner.nextInt()-1;
        Spell spell = knownSpells.get(spellIndex);
        int damage = spell.getDamage();
        System.out.println("Vous lancez " + spell.getName() + " en faisant tomber un rocher sur la tête et infligez  " + damage + " de dégâts au " + ennemies.getName() + "\n");
        ennemies.takeDamage(damage);

    }
    public void fight(AbstractEnemy ennemies){
        boolean Status = true; // Quand le combat n'est pas terminé
        while (Status) {
            Status = this.wizardturn(ennemies);
            ennemies.enemyturn(this);

        }
    }


    public void takeDamage(int damage1) {

        this.setHealth(getHealth() - damage1);

        System.out.println(this.getName() + " prend " + damage1 + " points de dégâts !");
        System.out.println("-----------------------------------------------");
        System.out.println("|      Il vous reste :" + getHealth() + " points de vie !     |");
        System.out.println("-----------------------------------------------");

        if (getHealth() <= 0) {
            this.setAlive(false);
            System.out.println(this.getName() + " est mort !");

        }
    }

    public void Healing(int heal1) {
        this.setHealth(getHealth() + heal1);
        if (getHealth() > 500) {
            this.setHealth(getHealth() -(getHealth()- max_health()));
            System.out.println("Vous avez " +  getHealth() + " points de vies");
        } else {

            System.out.println(this.getName() + " régénère " + heal1 + " points de vies !");
            System.out.println("------------------------------------------------------");
            System.out.println("|      Vous avez maintenant :" + getHealth() + " points de vie !     |");
            System.out.println("------------------------------------------------------");
        }
    }
    private boolean gotonextChapter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez vous passer au chapitre suivant ? : \n1.Oui \n2.Non je veux arreter le jeu");
        int numberSpell = scanner.nextInt();
        switch (numberSpell) {
            case 1:
                boolean clearchap = true;// The chapter is cleaned
                while (clearchap){
                    clearchap = this.passChapter();

                }
                return true;
            case 2:
                return false;

        }
        return gotonextChapter();
    }

    public void ChapterOne(){
        System.out.println("<----------Chapitre 1----------->\n");
        System.out.println("The Philosopher's Stone\n");
        System.out.println("Vous arrivez devant le donjon et vous sentez une odeur de durian sur vos mains et vous décidez d'aller au toilette...\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît ! Pour le terasser, il vous faut utiliser le sort Wingardium Leviosa !\n");
        Wait.wait(2000);
        this.fight(Enemy.createTroll());
        this.gotonextChapter();



    }
    public void ChapterTwo(){
        System.out.println("<----------Chapitre 2----------->\n");
        System.out.println("The Chamber of Secrets\n");
        System.out.println("Vous êtes face au terrible basilic. Si vous êtes de Griffondor, vous pouvez faire appel à l’épée\n" +
                "légendaire de Godric Gryffindor pour le terrasser. Sinon, il faudra lui arracher un de ses crocs et\n" +
                "l’utiliser pour détruire le journal de Tom Jedusor.\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
        this.fight(Enemy.createTroll());
        this.fight(Boss.createBasilik());
        this.gotonextChapter();


    }
    public void ChapterThree(){
        System.out.println("<----------Chapitre 3----------->\n");
        System.out.println("The Prisonner of Azkaban\n");
        System.out.println("Les Détraqueurs sont en liberté. Ils errent dans les rues, les campagnes. Heureusement, vous avez\n" +
                "entendu parler d’un sort pour les mettre en fuite... Expect... Expecta... Ah oui, Expectro Patronum.\n" +
                "Votre objecif est d’apprendre le sort, puis de l’utiliser pour vaincre les Détraqueurs.\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
        this.fight(Boss.createBasilik());
        this.fight(Boss.createVoledemort());
        this.gotonextChapter();
    }
    public void ChapterFour(){
        System.out.println("<----------Chapitre 4----------->\n");
        System.out.println("The Goblet of Fire\n\n");
        System.out.println("Par malheur, vous avez remporté le Tournoi des Trois Sorciers... et le droit de mourir. Vous êtes\n" +
                "dans un cimetière, où se trouvent aussi Voldemort et Peter Pettigrew. Votre seule chance de fuite est\n" +
                "de vous rapprocher du Portkey pour l’attirer à vous (Accio !). Ne vous inquiétez pas, vous reverrez\n" +
                "Voldemort.\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
    }
    public void ChapterFive(){
        System.out.println("<----------Chapitre 5----------->\n");
        System.out.println("The Order of the Phenix\n");
        System.out.println("C’est l’heure du BUSE (Brevet Universel de Sorcellerie Élémentaire) ! Dolores Ombrage veille sur\n" +
                "le grain. Votre objectif est de la distraire le temps que les feux d’artifice soient prêts à être utilisés.\n\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
    }
    public void ChapterSix(){
        System.out.println("<----------Chapitre 6----------->\n");
        System.out.println("The Half-Blood Prince\n");
        System.out.println("Les Mangemorts attaquent Poudlard. Êtes-vous prêts à vous défendre ? Vous devez les attaquer\n" +
                "de face (Sectumsempra). Si vous êtes de Serpentard, vous pouvez décider de rejoindre les rangs des\n" +
                "Mangemorts.\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
    }
    public void ChapterSeven(){
        System.out.println("<----------Chapitre 7----------->\n");
        System.out.println("The Deathly Hallows\n");
        System.out.println("Trêve de tergiversations, il faut attaquer le problème à la source. Vous êtes face à Voldemort et a\n" +
                "Bellatrix Lestrange. Faites attention, ils peuvent vous tuer d’un coup avec Avada Kedavra si vous\n" +
                "n’êtes pas prêts.\n");
        Wait.wait(2000);
        System.out.println("Un ennemi apparaît !\n");
        Wait.wait(2000);
    }

}







